plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.sampleapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.sampleapp"
        minSdk = 23
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
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
    // Core Android libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx) // Provides lifecycle-aware components

    // Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.navigation.compose) // For Jetpack Compose navigation
    implementation(libs.navigation.fragment) // For fragment-based navigation
    implementation(libs.navigation.fragment.compose) // For using Compose with fragment-based navigation

    // Jetpack Compose
    implementation(libs.androidx.activity.compose) // Integration for Compose in Activities
    implementation(platform(libs.androidx.compose.bom)) // Bill of Materials for consistent Compose versions
    implementation(libs.androidx.ui) // Core UI library for Compose
    implementation(libs.androidx.ui.graphics) // Graphics library for Compose
    implementation(libs.androidx.ui.tooling.preview) // For previewing Composable functions in Android Studio
    implementation(libs.androidx.material3) // Material Design 3 components for Compose
    implementation(libs.androidx.ui.android)


    // Additional Compose dependencies (can be grouped or removed if redundant with BOM)
    // For Activity-Compose integration (might be covered by libs.androidx.activity.compose)
    implementation(libs.androidx.activity.compose.v1101) // Provides Compose integration for Activities

    // Compose dependencies For navigation with compose
    implementation(libs.androidx.navigation.compose.v292) // Navigation specifically for Compose (might be covered by libs.navigation.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx.v292) // Lifecycle runtime for Kotlin (might be covered by libs.androidx.lifecycle.runtime.ktx)

    // Add the Compose UI tooling preview
    // and for to use [ComposeView] in XML activity
    implementation(libs.ui.tooling) // Compose UI tooling (might be covered by libs.androidx.ui.tooling or debugImplementation)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom)) // BOM for Compose testing
    androidTestImplementation(libs.androidx.ui.test.junit4) // For testing Compose UI

    // Debugging and Tooling
    debugImplementation(libs.androidx.ui.tooling) // Compose UI tooling for debugging
    debugImplementation(libs.androidx.ui.test.manifest) // Test manifest for Compose

}