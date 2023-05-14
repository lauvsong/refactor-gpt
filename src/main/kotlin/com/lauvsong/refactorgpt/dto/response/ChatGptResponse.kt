package com.lauvsong.refactorgpt.dto.response

import com.lauvsong.refactorgpt.dto.Refactored

data class ChatGptResponse(
    val id: String,
    var choices: List<Choice>
) {

    data class Choice(
        val index: Int,
        val text: String,
        val finishReason: String
    )

    fun toRefactored(): Refactored =
        Refactored(
            code = choices.first().text.trim()
        )
}
