package org.intellij.sdk.lore.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.ui.Messages
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiManager
import org.intellij.sdk.lore.LoreFileType
import org.intellij.sdk.lore.LoreIcons

class NewLoreFileAction : AnAction(
    "Lore File",
    "Create new Lore file",
    LoreIcons.FILE
) {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val directory = getSelectedDirectory(e) ?: return

        val fileName = Messages.showInputDialog(
            project,
            "Enter file name:",
            "New Lore File",
            Messages.getQuestionIcon()
        ) ?: return

        val fileExt = LoreFileType.defaultExtension
        val fullName = if (fileName.endsWith(".$fileExt")) fileName else "$fileName.$fileExt"

        WriteAction.run<Throwable> {
            directory.createFile(fullName)
        }
    }

    private fun getSelectedDirectory(e: AnActionEvent): PsiDirectory? {
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE) ?: return null
        val project = e.project ?: return null
        return PsiManager.getInstance(project).findDirectory(virtualFile)
    }
}