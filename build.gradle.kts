import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

plugins {
    kotlin("jvm") version "2.0.0"
    id("org.jetbrains.dokka") version "2.0.0"
}

group = "org.example"
version = "1.4.0-SNAPSHOT"

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

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets {
        configureEach {
            // used as project name in the header
            moduleName.set("Github playground")

            // contains descriptions for the module and the packages
            //includes.from("Module.md")

            // adds source links that lead to this repository, allowing readers
            // to easily find source code for inspected declarations
            sourceLink {
                localDirectory.set(file("src/main/kotlin"))
                remoteUrl.set(
                    URL("https://github.com/vgarciabnz/github-actions-playground/tree/master/src/main/kotlin")
                )
                remoteLineSuffix.set("#L")
            }
        }
    }
}
