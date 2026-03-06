package org.intellij.sdk.lore.line

import com.intellij.psi.tree.IElementType
import org.intellij.sdk.lore.LoreLanguage

object LoreTypes {
    val TITLE = IElementType("TITLE", LoreLanguage.Companion.INSTANCE)
    val LINK = IElementType("LINK", LoreLanguage.Companion.INSTANCE)
    val ATOM = IElementType("ATOM", LoreLanguage.Companion.INSTANCE)
    val EMPTY = IElementType("EMPTY", LoreLanguage.Companion.INSTANCE)

    val CONTENT = IElementType("CONTENT", LoreLanguage.Companion.INSTANCE)
    val EQ = IElementType("EQ", LoreLanguage.Companion.INSTANCE)
    val CRLF = IElementType("CRLF", LoreLanguage.Companion.INSTANCE)
}