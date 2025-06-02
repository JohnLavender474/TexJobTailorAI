plugins {
    id("java")
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.texjobtailorai"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.aallam.openai:openai-client:3.5.0")
    implementation("io.ktor:ktor-client-okhttp:2.3.4")
    implementation("org.apache.pdfbox:pdfbox:2.0.27")
    implementation("com.beust:jcommander:1.82")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation(kotlin("stdlib-jdk8"))

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.shadowJar {
    manifest {
        attributes["Main-Class"] = "com.texjobtailorai.MainKt"
    }
    archiveBaseName.set("TexJobTailorAI")
    archiveClassifier.set("")
    mergeServiceFiles()
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}