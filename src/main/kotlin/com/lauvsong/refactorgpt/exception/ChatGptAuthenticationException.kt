package com.lauvsong.refactorgpt.exception

class ChatGptAuthenticationException(
    message: String? = """
        Authentication failed. Check below things.
        1. API key settings configured in Settings.
        2. API key settings configured in OpenAI.
        3. Ensure a credit card is registered with OpenAI.
        If these steps do not resolve the issue, please get a new API key and try again.
        """
) : Exception(message)
