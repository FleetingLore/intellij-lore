package org.intellij.sdk.lore

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
        val lines = text.lines()
        var pos = startOffset

        for (line in lines) {
            val trimmed = line.trimStart()
            val lineEnd = pos + line.length

            when {
                trimmed.startsWith("+ ") -> {
                    tokenList.add(TokenData(LoreTypes.TITLE, pos, lineEnd))
                }
                trimmed.contains(" = ") -> {
                    tokenList.add(TokenData(LoreTypes.LINK, pos, lineEnd))
                }
                trimmed.isNotBlank() -> {
                    tokenList.add(TokenData(LoreTypes.ATOM, pos, lineEnd))
                }
                else -> {
                    tokenList.add(TokenData(LoreTypes.EMPTY, pos, lineEnd))
                }
            }

            pos = lineEnd + 1 // 跳过换行符
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