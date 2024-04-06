package com.lauvsong.refactorgpt.dto.request

data class ChatGptRequest(
    val model: String = "gpt-3.5-turbo",
    val messages: List<Message>,
    val temperature: Int = 0
) {

    data class Message(
        val role: String,
        val content: String
    )

    companion object {

        private val defaultSystemMessage = Message("system",
            """
                You role is perfect code refactoring output.
                Refactor the following code for better readability and maintainability.
                Return only the refactored code and don't say any explain.
            """.trimIndent())

        fun of(fileExtension: String, code: String): ChatGptRequest =
            ChatGptRequest(
                messages = listOf(defaultSystemMessage, Message("user", createPrompt(fileExtension, code)))
            )

        private fun createPrompt(fileExtension: String, code: String): String =
            """
                This code's file extension: $fileExtension
                Here is the code:
                ```
                $code
                ```
                Respond start with the line 'Code:'
            """.trimIndent()
    }
}
