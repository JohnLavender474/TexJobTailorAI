package com.textjobtailorai.clients

interface AiClient {

    suspend fun prompt(content: String): String
}