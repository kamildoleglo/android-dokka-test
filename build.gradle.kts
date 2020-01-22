import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("java")
    kotlin("jvm") version "1.3.61"
    id("org.jetbrains.dokka") version "0.11.0-SNAPSHOT"
}

group = "org.jetbrains.dokka"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testCompile(group = "junit", name = "junit", version = "4.12")
//    dokkaPlugins("org.jetbrains.dokka:mathjax-plugin:0.11.0-SNAPSHOT")
}



tasks {
    val dokkaOutputDir = "dokka"

    val clean = getByName("clean", Delete::class) {
        delete(rootProject.buildDir)
        delete(dokkaOutputDir)
    }

    val dokka by getting(DokkaTask::class) {
        dependsOn(clean)
        outputDirectory = dokkaOutputDir
        outputFormat = "html"

        configuration {
            sourceRoot {
                path = "stubs/"
            }
            noJdkLink = true
        }
    }
}