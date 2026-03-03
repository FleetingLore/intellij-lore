package org.intellij.sdk.lore;

import com.intellij.ide.IconProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class LorePropertyIconProvider extends IconProvider {

    @Override
    public @Nullable Icon getIcon(@NotNull PsiElement psiElement, int i) {
        return switch (psiElement) {
            case LoreTitleLine ignored -> LoreIcons.TITLE;
            case LoreLinkLine ignored -> LoreIcons.LINK;
            case LoreAtomLine ignored -> LoreIcons.ATOM;
            case LoreToken ignored -> LoreIcons.EMPTY;
            default -> null;
        };
    }
}