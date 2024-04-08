package com.lauvsong.refactorgpt.dto.request

data class ChatGptRequest(
    val model: String = "gpt-3.5-turbo-instruct",
    val prompt: String,
    val maxTokens: Int = 1600,
    val temperature: Int = 0
) {

    companion object {
        fun of(fileExtension: String, code: String): ChatGptRequest =
            ChatGptRequest(prompt = makePrompt(fileExtension, code))

        private fun makePrompt(fileExtension: String, code: String): String =
            """
                You role is perfect code refactoring prompt.
                Refactor the following code for better readability and maintainability.
                Don't say ANY explain. Just response the code strictly.
                This code's file extension: $fileExtension
                Here is the code:
                ```
                $code
                ```

                Respond start with the line 'Code:'
            """.trimIndent()
    }
}
