package com.texjobtailorai.clients

interface AiClient {

    suspend fun prompt(content: String): String
}