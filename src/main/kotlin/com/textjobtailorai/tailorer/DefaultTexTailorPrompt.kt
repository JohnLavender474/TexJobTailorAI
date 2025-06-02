package com.textjobtailorai.tailorer

val DEFAULT_TEX_TAILOR_PROMPT = """
    I need you to help tailor my resume to better match a job posting. Here are the instructions:
    
    1. Preserve all LaTeX formatting, commands, and structure exactly as they are
    2. Only modify the text content within sections
    3. Incorporate keywords and action verbs from the job posting
    4. Maintain the same meaning and factual accuracy
    5. Keep the same length and structure of bullet points
    6. Focus on matching the terminology from the job posting
    
    Job posting:
    {jobPosting}
    
    Current resume:
    {resume}
    
    Return the modified LaTeX with the same formatting but tailored content. Do not return anything else
    besides the modified LaTex. The output you generate will be directly compiled into PDF, so provide ONLY
    the modified compilable LaTex and nothing more. Also, try to keep the length of each line about the same
    or less than the original. The new resume file shouldn't be any longer than the original in terms of line
    length and character count. This includes not only bullet points but other things as well. For instance,
    if there is a Skills section, then the char count in the new Skills section should be the same as before.
    
    When creating the new resume, do not make up skills. Use only the information given in the original resume.
    For example, if the job listing asks for experience in Python but no Python experience is listed in the 
    original resume, then do not add Python experience to the new resume.
""".trimIndent()