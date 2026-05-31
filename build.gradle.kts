buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:9.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.10")
        classpath("com.mikepenz.aboutlibraries.plugin:aboutlibraries-plugin:11.2.3")
    }
}
plugins {
    id("com.google.devtools.ksp") version "2.3.9" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.3.21" apply false
}