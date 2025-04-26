plugins {
    id("com.android.application") version "8.9.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("org.jetbrains.kotlin.kapt") version "1.9.20" apply false
}
buildscript {

    repositories {

        maven (  "https://my-company-internal-maven-repo/")
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.1")
        classpath("com.android.tools.build:gradle:3.4.0-beta02")
        classpath(kotlin("gradle-plugin", version = "1.3.20"))
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
        maven("https://kotlin.bintray.com/kotlinx")
    }
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
}