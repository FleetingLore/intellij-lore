package org.intellij.sdk.lore.line

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import org.intellij.sdk.lore.LoreIcons

class LoreColorSettingsPage : ColorSettingsPage {
    override fun getIcon() = LoreIcons.FILE

    override fun getHighlighter() = LoreSyntaxHighlighter()

    override fun getDemoText() = """
        + title
        atom
        info = goto
        info | goto
        info > goto
    """.trimIndent()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String?, TextAttributesKey?> {
        return mapOf(
            "title" to LoreSyntaxHighlighter.TITLE,
            "atom" to LoreSyntaxHighlighter.ATOM,
            "link" to LoreSyntaxHighlighter.LINK
        )
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return arrayOf(
            AttributesDescriptor("Title", LoreSyntaxHighlighter.TITLE),
            AttributesDescriptor("Atom", LoreSyntaxHighlighter.ATOM),
            AttributesDescriptor("Link", LoreSyntaxHighlighter.LINK)
        )
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> = emptyArray()

    override fun getDisplayName(): String = "Lore"
}