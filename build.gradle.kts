plugins {
    kotlin("jvm") version "2.0.0"
    id("org.jetbrains.dokka") version "2.0.0"
}

group = "org.example"
version = "1.2-SNAPSHOT"

if (project.hasProperty("removeSnapshotSuffix")) {
    val mainVersion = (version as String).split("-SNAPSHOT")[0]
    version = mainVersion
}

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
    println("This comes from master $version")
}
