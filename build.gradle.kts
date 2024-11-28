// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
  //  alias(libs.plugins.android.application) version "8.5.2" apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    kotlin("kapt") version "1.8.10"  // Ensure kapt plugin is included for annotation processing
    // Add the Hilt plugin here
}

buildscript {
    repositories {
        google()       // Google's Maven repository for Android-specific dependencies
        mavenCentral() // Maven Central for other dependencies (including Koin)
        // jcenter()     // Optional: can be removed if no longer necessary
    }
    dependencies {
        // Ensure the correct Kotlin Gradle plugin version is included
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")

    }
}

// This ensures that the repositories are available for all modules (sub-projects)

