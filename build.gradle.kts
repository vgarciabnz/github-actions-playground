plugins {
    kotlin("jvm") version "2.0.0"
}

group = "org.example"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

task("printVersion") {
    println("Current version $version")
}
