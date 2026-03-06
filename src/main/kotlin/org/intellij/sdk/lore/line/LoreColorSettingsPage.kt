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
        info = goto
        info | goto
        info > goto
        atom
    """.trimIndent()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String?, TextAttributesKey?> {
        return mapOf(
            "title" to LoreSyntaxHighlighter.TITLE,
            "link" to LoreSyntaxHighlighter.LINK,
            "markdown" to LoreSyntaxHighlighter.MARKDOWN,
            "html" to LoreSyntaxHighlighter.HTML,
            "atom" to LoreSyntaxHighlighter.ATOM
        )
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return arrayOf(
            AttributesDescriptor("Title", LoreSyntaxHighlighter.TITLE),
            AttributesDescriptor("Link", LoreSyntaxHighlighter.LINK),
            AttributesDescriptor("Markdown", LoreSyntaxHighlighter.MARKDOWN),
            AttributesDescriptor("Html", LoreSyntaxHighlighter.HTML),
            AttributesDescriptor("Atom", LoreSyntaxHighlighter.ATOM)
        )
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> = emptyArray()

    override fun getDisplayName(): String = "Lore"
}