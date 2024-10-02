plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.dcac.learntogether"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dcac.learntogether"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Core KTX library that provides Kotlin extensions for Android.
// Helps simplify Android API usage with more concise and readable Kotlin code.
    implementation(libs.androidx.core.ktx)

// Runtime KTX for Lifecycle components, helps manage activity and fragment lifecycle.
// Assists in handling lifecycle events in a modern architecture.
    implementation(libs.androidx.lifecycle.runtime.ktx)

// Library for integrating Jetpack Compose into Android activities.
// Provides necessary components to use Compose in a standard Android activity.
    implementation(libs.androidx.activity.compose)

// BOM (Bill of Materials) for Compose, used to manage and harmonize versions of various Compose libraries.
// Simplifies dependency management for Compose by ensuring consistency between them.
    implementation(platform(libs.androidx.compose.bom))

// Main UI library for Jetpack Compose.
// Contains basic UI components to build apps with Jetpack Compose.
    implementation(libs.androidx.ui)

// Graphics library for Compose.
// Includes tools for managing colors, shapes, and other graphic elements.
    implementation(libs.androidx.ui.graphics)

// Preview tools for Compose.
// Allows previewing composables directly in the IDE without running the app on a real device or emulator.
    implementation(libs.androidx.ui.tooling.preview)

// Material Design 3 for Jetpack Compose.
// Provides modern Material Design components compatible with Jetpack Compose, including the latest updates from Material You.
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

// JUnit, a unit testing framework.
// Used to write and run unit tests in your application.
    testImplementation(libs.junit)

// AndroidX JUnit, used to write UI tests specific to Android.
// Integrates JUnit with Android components for UI testing.
    androidTestImplementation(libs.androidx.junit)

// Espresso, a UI testing framework for Android.
// Facilitates writing automated functional tests for user interaction in your application.
    androidTestImplementation(libs.androidx.espresso.core)

// Compose BOM for UI testing.
// Ensures that the versions of Compose testing libraries are consistent with the other Compose libraries used in the project.
    androidTestImplementation(platform(libs.androidx.compose.bom))

// Compose UI testing with JUnit4.
// Enables running UI tests on Jetpack Compose components using the JUnit4 framework.
    androidTestImplementation(libs.androidx.ui.test.junit4)

// Development tools for Compose.
// Provides additional debugging and UI inspection tools during development.
    debugImplementation(libs.androidx.ui.tooling)

// Tools for testing manifests during development.
// Includes extra testing functionality to manage manifest files during the debugging phase.
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(kotlin("script-runtime"))
}