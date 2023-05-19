package com.lauvsong.refactorgpt.service

import com.lauvsong.refactorgpt.api.ChatGptApi
import com.lauvsong.refactorgpt.dto.Refactored
import com.lauvsong.refactorgpt.dto.request.ChatGptRequest
import com.lauvsong.refactorgpt.dto.response.ChatGptResponse
import com.lauvsong.refactorgpt.exception.ChatGptAuthenticationException
import com.lauvsong.refactorgpt.exception.ChatGptFetchFailureException
import retrofit2.Response
import java.net.SocketTimeoutException

class ChatGptService(
    private val chatGptApi: ChatGptApi = ChatGptApi.create()
) {

    fun refactorCode(fileExtension: String, code: String): Refactored =
        runCatching {
            ChatGptRequest.of(fileExtension, code)
                .let { chatGptApi.refactorCode(it).execute() }
        }.fold(
            onSuccess = { response -> onRefactorSuccess(response) },
            onFailure = { exception ->
                if (exception is SocketTimeoutException) {
                    throw ChatGptFetchFailureException("timeout error. Please check your network or set longer timeout in settings.")
                }
                throw ChatGptFetchFailureException(exception.message)
            }
        )

    private fun onRefactorSuccess(response: Response<ChatGptResponse>): Refactored =
        takeUnless { response.code() == 401 }
            ?.let { response.body()?.toRefactored() }
            ?: throw ChatGptAuthenticationException()
}
