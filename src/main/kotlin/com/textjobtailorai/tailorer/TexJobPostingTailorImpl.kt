package com.textjobtailorai.tailorer

import com.aallam.openai.api.BetaOpenAI
import com.textjobtailorai.clients.AiClient

@OptIn(BetaOpenAI::class)
class TexJobPostingTailorImpl(private val client: AiClient) : ITexJobPostingTailor {

    override suspend fun run(
        originalTexContent: String,
        jobPostingContent: String,
        customPrompt: String?
    ): String {
        val content = (customPrompt ?: DEFAULT_TEX_TAILOR_PROMPT)
            .replace("{jobPosting}", jobPostingContent)
            .replace("{resume}", originalTexContent)

        return client.prompt(content)
    }
}