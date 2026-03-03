package org.intellij.sdk.lore

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class LoreSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return LoreLexer()  // 直接返回 LoreLexer，不用 Adapter
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            LoreTypes.TITLE -> TITLE_KEYS
            LoreTypes.LINK -> LINK_KEYS
            LoreTypes.ATOM -> ATOM_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        val TITLE: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "LORE_TITLE", DefaultLanguageHighlighterColors.KEYWORD
        )
        val LINK: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "LORE_LINK", DefaultLanguageHighlighterColors.STRING
        )
        val ATOM: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "LORE_ATOM", DefaultLanguageHighlighterColors.DOC_CODE_BLOCK
        )

        private val TITLE_KEYS = arrayOf(TITLE)
        private val LINK_KEYS = arrayOf(LINK)
        private val ATOM_KEYS = arrayOf(ATOM)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}