package org.intellij.sdk.lore;

import com.intellij.lang.Language;

public class LoreLanguage extends Language {

  public static final LoreLanguage INSTANCE = new LoreLanguage();

  private LoreLanguage() {
    super("Lore");
  }

}
