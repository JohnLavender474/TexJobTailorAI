#!/bin/bash

# TexTailorAI Runner Script
# Usage: ./run.sh [arguments]

# Configuration - Update these paths as needed
PROJECT_DIR="$(dirname "$0")"
BUILD_DIR="$PROJECT_DIR/build/libs"
MAIN_CLASS="com.texjobaiailor.Main"
JAR_NAME="TexJobTailorAI.jar"  # Update with your actual jar name

# Build the project if needed
if [ ! -f "$BUILD_DIR/$JAR_NAME" ]; then
    echo "Building project..."
    ./gradlew jar || {
        echo "Build failed"
        exit 1
    }
fi

# Run the application
java -jar "$BUILD_DIR/$JAR_NAME" "$@"