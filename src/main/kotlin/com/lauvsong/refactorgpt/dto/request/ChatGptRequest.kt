package com.lauvsong.refactorgpt.dto.request

data class ChatGptRequest(
    val model: String = "text-davinci-003",
    val prompt: String,
    val maxTokens: Int = 500,
    val temperature: Int = 0
) {

    companion object {
        fun of(fileExtension: String, code: String): ChatGptRequest =
            ChatGptRequest(prompt = makePrompt(fileExtension, code))

        private fun makePrompt(fileExtension: String, code: String): String =
            """
                You role is perfect code refactoring prompt.
                Refactor the following code for better readability and maintainability.
                Don't say ANY explain / small comments / empty lines / markdown code space.
                Response just ONLY code. Don't start with any backticks or explain.
                file extension: $fileExtension
                Here is the code:
                ```
                $code
                ```
            """.trimIndent()
    }
}
