package org.intellij.sdk.lore.line

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType

class LoreParser : PsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()

        while (!builder.eof()) {
            val tokenType = builder.tokenType
            when (tokenType) {
                LoreTypes.TITLE -> parseTitleLine(builder)
                LoreTypes.LINK -> parseLinkLine(builder)
                LoreTypes.MARKDOWN -> parseMarkdownLine(builder)
                LoreTypes.HTML -> parseHtmlLine(builder)
                LoreTypes.ATOM -> parseAtomLine(builder)
                LoreTypes.EMPTY -> parseEmptyLine(builder)
                else -> builder.advanceLexer() // 跳过未知 token
            }
        }

        rootMarker.done(root)
        return builder.treeBuilt
    }

    private fun parseTitleLine(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // 消费 TITLE
        // 这里可以解析 CONTENT
        marker.done(LoreTypes.TITLE)
    }

    private fun parseLinkLine(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // 消费 LINK
        marker.done(LoreTypes.LINK)
    }

    private fun parseMarkdownLine(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // 消费 MARKDOWN
        marker.done(LoreTypes.MARKDOWN)
    }

    private fun parseHtmlLine(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // 消费 HTML
        marker.done(LoreTypes.HTML)
    }

    private fun parseAtomLine(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // 消费 ATOM
        marker.done(LoreTypes.ATOM)
    }

    private fun parseEmptyLine(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // 消费 EMPTY
        marker.done(LoreTypes.EMPTY)
    }
}
