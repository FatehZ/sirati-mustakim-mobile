@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    kotlin("android")
    id ("com.google.devtools.ksp") version "1.9.10-1.0.13"
}

android {
    namespace = "com.ktxdevelopment.siratimustakim.android"
    compileSdk = Versions.compileSdk
    defaultConfig {
        applicationId = "com.ktxdevelopment.siratimustakim.android"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = App.versionCode
        versionName = App.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinCompose)

    implementation(SupportLibraries.material)

    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.lifecycle)
    implementation(Libraries.Compose.material)
    implementation(Libraries.Compose.uiToolingPreview)
    implementation(Libraries.Compose.coil)
    implementation(Libraries.Compose.activity)
    implementation(Libraries.Compose.navigation)
    implementation("androidx.compose.ui:ui-text-android:1.5.3")
}