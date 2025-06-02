package com.texjobtailorai

import com.texjobtailorai.analysis.DEFAULT_ANALYSIS_PROMPT
import com.texjobtailorai.cl.CommandLineArgsBuilder
import com.texjobtailorai.cleanup.OutputTexCleaner
import com.texjobtailorai.clients.AiClientProvider
import com.texjobtailorai.coverletter.DEFAULT_COVER_LETTER_PROMPT
import com.texjobtailorai.tailorer.TexJobPostingTailorImpl
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

            val outputAnalysisPath = "${args.output}-analysis.txt"
            File(outputAnalysisPath).writeText(analysis)

            print("Analysis written to $outputAnalysisPath")
        }

        if (args.coverLetter) {
            val content = DEFAULT_COVER_LETTER_PROMPT
                .replace("{jobPosting}", jobPostingContent)
                .replace("{resume}", cleanTailoredContent)

            val coverLetter = runBlocking { client.prompt(content) }

            File(args.coverLetterDest).writeText(coverLetter)

            print("Cover letter written to ${args.coverLetterDest}")
        }
    }
}