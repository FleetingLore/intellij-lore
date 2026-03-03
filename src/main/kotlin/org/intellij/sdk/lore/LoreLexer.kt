package org.intellij.sdk.lore

import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.psi.tree.IElementType

/**
 * Lore 语言的词法分析器 (Lexer)
 *
 * 作用：将文本文件转换成 Token 流，供 Parser 使用。
 *
 * 工作流程：
 * 1. IDE 调用 start() 传入整个文件内容
 * 2. 你在 start() 里解析文本，生成 Token 列表
 * 3. IDE 反复调用 advance() + getTokenType() 遍历 Token
 *
 * Token 是什么：文本中的一个“词块”，比如：
 * - "+ " 是一个 Token (PLUS)
 * - "hello" 是一个 Token (CONTENT)
 * - " = " 是一个 Token (EQ)
 * - 整行也可以是一个 Token (PLUS_LINE)
 *
 * 你需要实现的方法：
 */
class LoreLexer : Lexer() {

    // ---------- 数据存储（你需要自己定义）----------
    // private var buffer: CharSequence = ""           // 当前处理的文本
    // private var startOffset: Int = 0                 // 起始位置
    // private var endOffset: Int = 0                    // 结束位置
    // private var tokenList: List<TokenData> = listOf() // 解析出的 Token 列表
    // private var currentIndex: Int = 0                 // 当前 Token 索引
    //
    // data class TokenData(
    //     val type: IElementType,  // Token 类型（如 LoreTypes.PLUS_LINE）
    //     val start: Int,           // 在文件中的起始位置
    //     val end: Int              // 在文件中的结束位置
    // )

    /**
     * 初始化 Lexer，准备开始词法分析
     *
     * @param buffer 整个文件的文本内容
     * @param startOffset 从这个位置开始分析（通常是 0）
     * @param endOffset 分析到这个位置结束（通常是 buffer.length）
     * @param initialState 初始状态（用不到可以忽略）
     *
     * 你需要做的：
     * 1. 保存 buffer, startOffset, endOffset 到成员变量
     * 2. 解析 buffer 中从 startOffset 到 endOffset 的文本
     * 3. 将解析出的 Token 存入 tokenList
     * 4. 重置 currentIndex = 0
     */
    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        TODO("""
            实现步骤：
            1. 保存参数到成员变量
            2. 获取文本: val text = buffer.subSequence(startOffset, endOffset).toString()
            3. 按行分割: text.lines()
            4. 遍历每一行:
               - 去掉行首空格: val trimmed = line.trimStart()
               - 判断行类型:
                 when {
                     trimmed.startsWith("+ ") -> LoreTypes.PLUS_LINE
                     trimmed.contains(" = ") -> LoreTypes.LINK_LINE
                     trimmed.isNotBlank() -> LoreTypes.TEXT_LINE
                     else -> LoreTypes.EMPTY_LINE
                 }
               - 记录 Token: tokenList.add(TokenData(类型, 起始位置, 结束位置))
            5. 重置 currentIndex = 0
        """.trimIndent())
    }

    /**
     * 返回当前 Token 的类型
     *
     * @return 当前 Token 的类型，如果没有更多 Token 则返回 null
     *
     * 你需要做的：
     * - 如果 currentIndex 超出 tokenList 范围，返回 null
     * - 否则返回 tokenList[currentIndex].type
     */
    override fun getTokenType(): IElementType? {
        TODO("返回当前 Token 的类型")
    }

    /**
     * 返回当前 Token 在文件中的起始位置
     */
    override fun getTokenStart(): Int {
        TODO("返回当前 Token 的起始位置")
    }

    /**
     * 返回当前 Token 在文件中的结束位置
     */
    override fun getTokenEnd(): Int {
        TODO("返回当前 Token 的结束位置")
    }

    /**
     * 移动到下一个 Token
     *
     * 你需要做的：
     * - currentIndex++
     */
    override fun advance() {
        TODO("移动到下一个 Token")
    }

    /**
     * 返回当前词法分析器的状态（用于恢复位置）
     * 简单实现可以返回 0
     */
    override fun getState(): Int {
        return 0
    }

    /**
     * 返回当前的位置信息，用于 restore() 恢复
     */
    override fun getCurrentPosition(): LexerPosition {
        return object : LexerPosition {
            override fun getOffset(): Int = getTokenStart()
            override fun getState(): Int = getState()
        }
    }

    /**
     * 恢复到之前保存的位置
     * 简单实现可以重新 start()
     */
    override fun restore(position: LexerPosition) {
        start(bufferSequence, position.offset, bufferEnd, position.state)
    }

    /**
     * 返回整个文本内容
     */
    override fun getBufferSequence(): CharSequence {
        TODO("返回你保存的 buffer")
    }

    /**
     * 返回文本结束位置
     */
    override fun getBufferEnd(): Int {
        TODO("返回你保存的 endOffset")
    }
}