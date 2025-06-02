package com.textjobtailorai

import com.textjobtailorai.analysis.DEFAULT_ANALYSIS_PROMPT
import com.textjobtailorai.cl.CommandLineArgsBuilder
import com.textjobtailorai.cleanup.OutputTexCleaner
import com.textjobtailorai.clients.AiClientProvider
import com.textjobtailorai.tailorer.DEFAULT_TEX_TAILOR_PROMPT
import com.textjobtailorai.tailorer.TexJobPostingTailorImpl
import kotlinx.coroutines.runBlocking
import java.io.File

class TexJobTailorAI {

    fun run(args: Array<String>) {
        val args = CommandLineArgsBuilder().build(args)

        val originalTexContent = File(args.original).readText()
        val jobPostingContent = File(args.jobPosting).readText()

        val client = AiClientProvider().get(args.client)
        if (client == null) throw IllegalArgumentException("No ai client for ${args.client}")

        val tailor = TexJobPostingTailorImpl(client)

        val rawTailoredContent = runBlocking { tailor.run(originalTexContent, jobPostingContent) }
        print("Raw tailored content:\n$rawTailoredContent")

        val cleanTailoredContent = OutputTexCleaner().clean(rawTailoredContent)
        print("Clean tailored content:\n$cleanTailoredContent")

        val outputTexPath = "${args.output}.tex"
        File(outputTexPath).writeText(cleanTailoredContent)
        print("Tailored resume written to $outputTexPath")

        if (args.analysis) {
            val content = DEFAULT_ANALYSIS_PROMPT
                .replace("{jobPosting}", jobPostingContent)
                .replace("{original}", originalTexContent)
                .replace("{new}", cleanTailoredContent)

            val analysis = runBlocking { client.prompt(content) }

            print("AI analysis:\n---\n$analysis")
        }
    }
}