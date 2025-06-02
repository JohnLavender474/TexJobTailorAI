package com.textjobtailorai.tailorer

interface ITexJobPostingTailor {

    suspend fun run(
        originalTexContent: String,
        jobPostingContent: String,
        customPrompt: String? = null
    ): String
}