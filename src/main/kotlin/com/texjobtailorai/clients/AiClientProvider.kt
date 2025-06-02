package com.texjobtailorai.clients

import com.texjobtailorai.config.EnvProvider
import com.texjobtailorai.utils.Provider

class AiClientProvider : Provider<String, AiClient?> {

    override fun get(key: String) = when (key) {
        "openai-gpt-4" -> {
            val apiKey = EnvProvider.get("OPENAI_API_KEY")
            apiKey?.let { OpenAiGpt4Client(it) }
        }
        else -> null
    }
}