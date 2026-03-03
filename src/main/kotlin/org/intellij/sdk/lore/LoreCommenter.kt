package org.intellij.sdk.lore

import com.intellij.lang.Commenter

internal class LoreCommenter : Commenter {
    override fun getLineCommentPrefix(): String {
        return "#"
    }

    override fun getBlockCommentPrefix(): String {
        return "/*"
    }

    override fun getBlockCommentSuffix(): String {
        return "*/"
    }

    override fun getCommentedBlockCommentPrefix(): String {
        return "/*"
    }

    override fun getCommentedBlockCommentSuffix(): String {
        return "*/"
    }
}