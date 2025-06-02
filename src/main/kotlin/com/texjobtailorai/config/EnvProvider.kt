package com.texjobtailorai.config

import com.texjobtailorai.utils.Provider
import io.github.cdimascio.dotenv.dotenv

object EnvProvider: Provider<String, String?> {

    private val dotenv = dotenv()

    override fun get(key: String): String? = dotenv[key]
}