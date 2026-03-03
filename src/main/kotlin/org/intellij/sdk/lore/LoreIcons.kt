package org.intellij.sdk.lore

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object LoreIcons {
    @JvmField
    val FILE: Icon = IconLoader.getIcon("/icons/lore-file.svg", LoreIcons::class.java)

    @JvmField
    val TITLE: Icon = IconLoader.getIcon("/icons/title.svg", LoreIcons::class.java)

    @JvmField
    val LINK: Icon = IconLoader.getIcon("/icons/link.svg", LoreIcons::class.java)

    @JvmField
    val ATOM: Icon = IconLoader.getIcon("/icons/atom.svg", LoreIcons::class.java)

    @JvmField
    var EMPTY: Icon = IconLoader.getIcon("/icons/empty.svg", LoreIcons::class.java)
}