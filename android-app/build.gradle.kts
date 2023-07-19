@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    kotlin("android")
    id ("com.google.devtools.ksp") version "1.8.21-1.0.11"
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
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
//
//dependencies {
//    val koinComposeVersion = "3.4.1"
//    val coilVersion = "2.2.2"
//    val accompanistVersion = "0.28.0"
//    val navVersion = "2.5.3"
//
//    implementation(project(":shared"))
//    implementation("androidx.compose.ui:ui:1.4.3")
//    implementation("androidx.compose.ui:ui-tooling:1.4.3")
//    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
//    implementation("androidx.compose.foundation:foundation:1.4.3")
//    implementation("androidx.compose.material:material:1.4.3")
//    implementation("androidx.activity:activity-compose:1.7.2")
//    implementation("io.ktor:ktor-client-android:2.3.2")
//
//
//    implementation("io.insert-koin:koin-androidx-compose:3.4.5")
//    implementation("io.coil-kt:coil-compose:2.4.0")
//    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
//    implementation("androidx.navigation:navigation-compose:2.6.0")
//
//    implementation("io.insert-koin:koin-core:$koinComposeVersion")
//    implementation("io.insert-koin:koin-test:$koinComposeVersion")
//    implementation("io.insert-koin:koin-android:$koinComposeVersion")
//
//}

dependencies {
    implementation(project(":shared"))

    implementation(Libraries.koinAndroid)

    implementation(SupportLibraries.material)

    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.lifecycle)
    implementation(Libraries.Compose.material)
    implementation(Libraries.Compose.uiToolingPreview)
    implementation(Libraries.Compose.coil)
    implementation(Libraries.Compose.activity)
    implementation(Libraries.Compose.navigation)
}