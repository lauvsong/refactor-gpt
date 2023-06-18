package com.lauvsong.refactorgpt.action

import com.lauvsong.refactorgpt.dialog.RefactorGptDialog
import com.lauvsong.refactorgpt.settings.SettingsState
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import javax.swing.Icon

class RefactorGptAction : AnAction() {

    private val settings = SettingsState.instance
    private var warningIcon: Icon? = null

    init {
        updateWarningIcon()
    }

    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project ?: return
        val editor = event.getRequiredData(CommonDataKeys.EDITOR)
        val selectedCode = editor.selectionModel.selectedText

        if (selectedCode.isNullOrBlank()) {
            showSelectDialog(project)
            return
        }

        if (settings.isApiKeyNotExists()) {
            showApiKeyWarning(project)
            return
        }

        val dialog = RefactorGptDialog(editor, project, selectedCode)

        dialog.show()
    }

    override fun update(event: AnActionEvent) {
        super.update(event)
        updateWarningIcon()
    }

    private fun updateWarningIcon() {
        warningIcon = if (settings.isApiKeyNotExists()) {
            AllIcons.General.Warning
        } else {
            null
        }
        templatePresentation.icon = warningIcon
    }

    private fun showSelectDialog(project: Project) {
        Messages.showMessageDialog(
            project,
            "Please Select Code",
            "Code Not Selected",
            Messages.getWarningIcon()
        )
    }

    private fun showApiKeyWarning(project: Project) {
        Messages.showMessageDialog(
            project,
            "Please Set Api Key. Settings > Other Settings > RefactorGPT",
            "Api Key Not Found",
            Messages.getWarningIcon()
        )
    }
}
