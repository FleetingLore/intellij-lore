package org.intellij.sdk.lore.line

import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.psi.tree.IElementType

class LoreLexer : Lexer() {
    private var buffer: CharSequence = ""
    private var startOffset: Int = 0
    private var endOffset: Int = 0
    private var tokenList: MutableList<TokenData> = mutableListOf()
    private var currentIndex: Int = 0

    data class TokenData(val type: IElementType, val start: Int, val end: Int)

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.currentIndex = 0
        this.tokenList.clear()

        val text = buffer.subSequence(startOffset, endOffset).toString()

        // 如果是空文件，直接返回
        if (text.isEmpty()) return

        val lines = text.lines()
        var pos = startOffset

        for ((index, line) in lines.withIndex()) {
            val trimmed = line.trimStart()
            val lineEnd = pos + line.length

            // 1. 添加行内容 Token
            when {
                trimmed.startsWith("+ ") -> tokenList.add(TokenData(LoreTypes.TITLE, pos, lineEnd))
                trimmed.contains(" = ") -> tokenList.add(TokenData(LoreTypes.LINK, pos, lineEnd))
                trimmed.contains(" > ") -> tokenList.add(TokenData(LoreTypes.MARKDOWN, pos, lineEnd))
                trimmed.contains(" | ") -> tokenList.add(TokenData(LoreTypes.HTML, pos, lineEnd))
                trimmed.isNotBlank() -> tokenList.add(TokenData(LoreTypes.ATOM, pos, lineEnd))
                else -> tokenList.add(TokenData(LoreTypes.EMPTY, pos, lineEnd))
            }

            // 2. 如果不是最后一行，添加 CRLF Token
            if (index < lines.size - 1) {
                tokenList.add(TokenData(LoreTypes.CRLF, lineEnd, lineEnd + 1))
            }

            pos = lineEnd + 1
        }
    }

    override fun getTokenType(): IElementType? {
        if (currentIndex >= tokenList.size) return null
        return tokenList[currentIndex].type
    }

    override fun getTokenStart(): Int = tokenList.getOrNull(currentIndex)?.start ?: 0
    override fun getTokenEnd(): Int = tokenList.getOrNull(currentIndex)?.end ?: 0
    override fun advance() { currentIndex++ }
    override fun getState(): Int = 0
    override fun getBufferSequence(): CharSequence = buffer
    override fun getBufferEnd(): Int = endOffset

    override fun getCurrentPosition(): LexerPosition {
        return object : LexerPosition {
            override fun getOffset(): Int = getTokenStart()
            override fun getState(): Int = getState()
        }
    }

    override fun restore(position: LexerPosition) {
        start(buffer, position.offset, endOffset, position.state)
    }
}