plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt") // Enable kapt plugin for annotation processing
}

android {
    namespace = "com.interview.erakulis"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.interview.erakulis"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17" // Set Kotlin JVM target to 17
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // AndroidX Core - Essential extension functions for Android.
    implementation("androidx.core:core-ktx:1.10.1")

    // AndroidX AppCompat - Compatibility support for modern Android features.
    implementation("androidx.appcompat:appcompat:1.7.0")

    // AndroidX ConstraintLayout - Layout manager for building complex layouts.
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // AndroidX Lifecycle ViewModel - Used to manage UI-related data lifecycle-consciously.
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")

    // AndroidX Lifecycle LiveData - Observables for lifecycle-aware data handling.
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")

    // AndroidX Lifecycle Runtime - Handles lifecycle-related events and lifecycle-aware components.
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")

    // AndroidX Activity KTX - Kotlin extensions for Android's Activity class.
    implementation("androidx.activity:activity-ktx:1.7.2")

    // AndroidX Navigation Fragment - Fragment-specific navigation.
    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")

    // AndroidX Navigation UI - UI-related components for navigation (e.g., NavigationView, AppBar).
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")

    // Retrofit - HTTP client for interacting with REST APIs.
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // Retrofit Gson Converter - Converter for serializing and deserializing JSON using Gson.
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp Logging Interceptor - Intercepts and logs HTTP requests and responses.
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    // AndroidX DataBinding - Enables declarative data-binding between UI and data models.
    implementation("androidx.databinding:databinding-runtime:7.4.0")

    // Kotlin Coroutines - Support for asynchronous programming with coroutines.
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0")

    implementation("io.coil-kt:coil:2.3.0")

    // Koin Android Core
    implementation("io.insert-koin:koin-android:3.4.0")             // Main Koin for Android
    implementation("io.insert-koin:koin-androidx-viewmodel:3.4.0")   // Koin ViewModel support

    // Remove `koin-android-compat`, as it's no longer needed for most cases
    // implementation("io.insert-koin:koin-android-compat:3.4.0")    // REMOVE this line

    // Optional: Koin for ViewModel if you're using Koin for ViewModel DI
    // No longer necessary to include koin-androidx-ext
}
