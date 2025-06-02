package com.texjobtailorai.coverletter

val DEFAULT_COVER_LETTER_PROMPT = """
    Please write a cover letter based on the following job posting and resume. Your output should contain
    ONLY the cover letter and nothing more. I want to be able to send the output you provide directly into
    the application. The format of your output should be the following. Do not include any markdown formatting.
    Keep it all in plain text.
    
    ```
    To whom it may concern,
    
    My name is... [Give a quick summary of my skills here]
    
    Talk about position 1 from my resume...
    
    Talk about position 2 from my resume...
    
    ... so on and so forth.
    
    Write conclusion here. Give quick summary of why I'm a good fit for the company and say thank you
    to the hiring team for considering me for this position. Provide my phone number and/or email if and 
    only if the info is included in the resume.
    ```
    
    ---
    
    Job posting:
    {jobPosting}
    
    ---
    
    Resume:
    {resume}   
""".trimIndent()