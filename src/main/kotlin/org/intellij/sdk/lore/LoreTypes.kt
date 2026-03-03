package org.intellij.sdk.lore

import com.intellij.psi.tree.IElementType

object LoreTypes {
    val TITLE = IElementType("TITLE", LoreLanguage.INSTANCE)
    val LINK = IElementType("LINK", LoreLanguage.INSTANCE)
    val ATOM = IElementType("ATOM", LoreLanguage.INSTANCE)
    val EMPTY = IElementType("EMPTY", LoreLanguage.INSTANCE)

    val CONTENT = IElementType("CONTENT", LoreLanguage.INSTANCE)
    val EQ = IElementType("EQ", LoreLanguage.INSTANCE)
    val CRLF = IElementType("CRLF", LoreLanguage.INSTANCE)
}
