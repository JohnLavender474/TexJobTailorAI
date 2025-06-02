package com.texjobtailorai.cl

import com.beust.jcommander.Parameter

class CommandLineArgs {

    @Parameter(
        names = ["--client"],
        description = "Client for AI tailor",
        required = true
    )
    var client: String = ""

    @Parameter(
        names = ["--original"],
        description = "The path to the original LaTex resume file",
        required = true
    )
    var original: String = ""

    @Parameter(
        names = ["--jobPosting"],
        description = "Path to the text file containing the job posting description",
        required = true
    )
    var jobPosting: String = ""

    @Parameter(
        names = ["--output"],
        description = "Path for the output file",
        required = true
    )
    var output: String = ""

    @Parameter(
        names = ["--analysis"],
        description = "Get a detailed analysis from AI. This will incur more usage of the API. Defaults to false.",
        required = false
    )
    var analysis: Boolean = false

    @Parameter(
        names = ["--coverLetter"],
        description = "Get a cover letter based on the job posting and new resume. Defaults to false.",
        required = false
    )
    var coverLetter: Boolean = false

    @Parameter(
        names = ["--coverLetterDest"],
        description = "The file path for the cover letter. Doesn't do anything if \"--coverLetter\" is false.",
        required = false
    )
    var coverLetterDest: String = ""
}