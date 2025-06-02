package com.texjobtailorai.clients

import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.texjobtailorai.config.EnvProvider
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class OpenAiGpt4Client(apiKey: String) : AiClient {

    companion object {
        private const val DEFAULT_TEMPERATURE = 0.3
        private const val DEFAULT_MODEL = "gpt-4.1"
        private val REQUEST_TIMEOUT = 3.minutes
        private val SOCKET_TIMEOUT = 3.minutes
        private val CONNECT_TIMEOUT = 30.seconds
    }

    private val openAI = OpenAI(
        apiKey,
        timeout = Timeout(
            request = REQUEST_TIMEOUT,
            socket = SOCKET_TIMEOUT,
            connect = CONNECT_TIMEOUT
        )
    )

    override suspend fun prompt(content: String): String {
        val model = EnvProvider.get("OPENAI_MODEL") ?: DEFAULT_MODEL
        val temperature = EnvProvider.get("OPENAI_TEMPERATURE")?.toDouble() ?: DEFAULT_TEMPERATURE

        val request = ChatCompletionRequest(
            model = ModelId(model),
            messages = listOf(
                ChatMessage(
                    role = ChatRole.User,
                    content = content
                )
            ),
            temperature = temperature
        )

        val completion = openAI.chatCompletion(request)

        return completion.choices.firstOrNull()?.message?.content ?: error("No response from client")
    }
}