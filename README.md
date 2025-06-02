# TexTailorAI

AI-powered LaTeX resume tailoring system that adapts your resume to match job postings.

## Features

- **AI-Powered Tailoring**: [Describe your AI integration approach]
- **LaTeX Preservation**: Maintains original LaTeX formatting while modifying content
- **Keyword Optimization**: [Detail how you handle ATS keyword matching]
- **Analysis Mode**: Provides feedback on resume-job posting alignment

## Installation

### Prerequisites
- [JDK](https://www.oracle.com/java/technologies/downloads/)
- [OpenAI API Key](https://platform.openai.com/api-keys) or an alternative AI service API key

### Setup
First, run the following to pull in the project to the current working directory, and then
change directory to the project directory.
```bash
git clone https://github.com/YOUR_USERNAME/TexTailorAI.git
cd TexTailorAI
```

Next, set up your `.env` file. If a `.env` does not exist in the project root directory,
then create one.

```bash
touch ./.env
```

The contents of the `.env` file depends on the AI client you plan to use. If using the OpenAI 
GPT-4 client, then add the following entry to the `.env` file.

```properties
OPENAI_API_KEY=<secret-api-key-here>
```

Additionally, you can add the following optional entries into the `.env` file for the OpenAI 
GPT-4 client.

```properties
# defaults to gpt-4.1; must be a string and be an existing model
OPENAI_MODEL=<model-name-here>

# the "temperature" to be requested; must be a double; defaults to 0.3 
OPENAI_TEMPERATURE=<temperature-here>
```

After the `.env` file has been setup, you may run the following command.

```bash
./run.sh --analysis --client <client> --original <path-to-original-resume-tex-file> --jobPosting <path-to-job-posting-txt-file> --output <output-file-name>
```

For example, this might be the following.
```bash
./run.sh --analysis --client openai-gpt-4 --original /home/johnlavender/Desktop/John-Lavender-resume.tex --jobPosting /home/johnlavender/Desktop/JobPosting.txt --output /home/johnlavender/Desktop/John-Lavender-resume
```

Notice that for the _output_ argument value, no file extension is provided. This is because the program will write multiple
files that have the same name but that each have a different extension. 

If you have run `run.sh` before, then there will be a `build` directory at the root of the project. If you make changes
to the code, then you will most likely want to trigger a rebuild of the JAR by deleting the entire `build` directory 
before running `run.sh`.

## Supporting other AI clients

Currently, the project supports only OpenAI's GPT-4 model. To add support for other clients, you will need to fork this
project and add the logic to support them.