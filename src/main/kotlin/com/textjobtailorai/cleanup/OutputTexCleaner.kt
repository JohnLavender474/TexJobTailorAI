package com.textjobtailorai.cleanup

class OutputTexCleaner {

    fun clean(output: String): String {
        val lines = output.split("\n")
        val filtered = lines.filter { line -> !line.contains("```") }
        return filtered.joinToString("\n")
    }
}