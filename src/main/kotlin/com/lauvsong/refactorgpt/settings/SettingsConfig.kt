package com.lauvsong.refactorgpt.settings

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class SettingsConfig : Configurable {
    private val form = SettingsForm()
    private val state = SettingsState.instance

    override fun createComponent(): JComponent =
        form.panel

    override fun isModified(): Boolean =
        form.isModified ||
            (form.apiKey != state.apiKey) ||
            (form.responseTimeout != state.responseTimeout)

    override fun apply() {
        state.apiKey = form.apiKey
        state.responseTimeout = form.responseTimeout
        form.apply()
    }

    override fun reset() {
        form.apiKey = state.apiKey
        form.responseTimeout = state.responseTimeout
    }

    override fun getDisplayName(): String {
        return "RefactorGPT"
    }
}
