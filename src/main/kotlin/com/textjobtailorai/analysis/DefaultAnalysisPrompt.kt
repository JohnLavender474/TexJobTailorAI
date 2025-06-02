package com.textjobtailorai.analysis

val DEFAULT_ANALYSIS_PROMPT = """
    I have two versions of my resume and a job posting. The first version of the resume is the 
    "original" version of my resume. The second is a new version which was created using AI to
    try to make a resume that is more tailor-fitted to the job posting.
    
    I need you to compare the original version and the new version against the job posting. Is
    the new version an improvement in terms of action words and key words that are contained
    in the job posting? Try to score the resume.
    
    Here's the original resume:
    {original}
    
    Here's the new resume:
    {new}
    
    Here's the job posting:
    {jobPosting}   
""".trimIndent()