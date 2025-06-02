import org.gradle.kotlin.dsl.implementation

plugins {
    id("java")
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.aallam.openai:openai-client:3.5.0")
    implementation("io.ktor:ktor-client-okhttp:2.3.4")
    implementation("org.apache.pdfbox:pdfbox:2.0.27")
    implementation("com.beust:jcommander:1.82")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}