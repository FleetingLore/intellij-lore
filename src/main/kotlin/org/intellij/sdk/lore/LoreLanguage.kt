package org.intellij.sdk.lore

import com.intellij.lang.Language

class LoreLanguage private constructor() : Language("Lore") {
    companion object {
        val INSTANCE = LoreLanguage()
    }
}