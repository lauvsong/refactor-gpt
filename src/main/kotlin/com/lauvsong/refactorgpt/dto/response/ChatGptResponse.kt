package com.lauvsong.refactorgpt.dto.response

import com.lauvsong.refactorgpt.dto.Refactored

data class ChatGptResponse(
    val id: String,
    val choices: List<Choice>,
    val finishReason: String,
    val usage: Usage
) {

    data class Choice(
        val index: Int,
        val messages: List<Message>
    ) {

        data class Message(
            val role: String,
            val content: String
        )
    }

    data class Usage(
        val promptTokens: Int,
        val completionTokens: Int,
        val totalTokens: Int,
    )

    fun toRefactored(): Refactored {
        return Refactored(
            code = choices.first()
                .messages
                .first()
                .content
                .substringAfter("Code:")
                .trim('`', '\n', ' ')
        )
    }
}
