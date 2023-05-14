package com.lauvsong.refactorgpt.api

import com.lauvsong.refactorgpt.dto.request.ChatGptRequest
import com.lauvsong.refactorgpt.dto.response.ChatGptResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

fun interface ChatGptApi {

    @POST("v1/completions")
    fun refactorCode(@Body request: ChatGptRequest): Call<ChatGptResponse>

    companion object {

        fun create(): ChatGptApi =
            ChatGptApiClient
                .getClient()
                .create(ChatGptApi::class.java)
    }
}
