plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all { kotlinOptions { jvmTarget = "1.8" } }
    }

//    listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach {
//        it.binaries.framework {
//            baseName = "shared"
//        }
//    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }


    val coroutinesVersion = "1.6.4"
    val ktorVersion = "2.2.4"
    val koinVersion = "3.4.1"
    val sqlDelightVersion = "1.5.5"
    val dateTimeVersion = "0.4.0"


    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libraries.Common.Ktor.core)
                implementation(Libraries.Common.Ktor.content)
                implementation(Libraries.Common.Ktor.serializationJson)
                implementation(Libraries.Common.Ktor.logging)
                implementation(Libraries.Common.sqlDelight)
//                implementation(Libraries.Common.gson)
//                implementation(Libraries.Common.sqlDriver)
                implementation(Libraries.Common.sqlDelightExtension)
                implementation(Libraries.Common.kotlinxSerializationCore)
                implementation(Libraries.Common.kotlinxCoroutinesCore)
                implementation(Libraries.Common.koinCore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Libraries.Android.sqlDelight)
                implementation(Libraries.Android.ktorClient)
                implementation(Libraries.Android.sqlDriver)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Libraries.IOs.sqlDriver)
                implementation(Libraries.IOs.sqlDelight)
                implementation(Libraries.IOs.ktorClient)
            }
        }

//         val androidTest by getting {
//             dependencies {
//                 implementation(kotlin("test-junit"))
//                 implementation("junit:junit:4.13.2")
//             }
//         }

//        val iosX64Main by getting
//        val iosArm64Main by getting
//        val iosSimulatorArm64Main by getting
//        val iosMain by creating {
//            dependencies {
//                implementation(Libraries.IOs.ktorClient)
//                implementation(Libraries.IOs.sqlDelight)
//            }
//            dependsOn(commonMain)
//            iosX64Main.dependsOn(this)
//            iosArm64Main.dependsOn(this)
//            iosSimulatorArm64Main.dependsOn(this)
//        }
//        val iosX64Test by getting
//        val iosArm64Test by getting
//        val iosSimulatorArm64Test by getting
//        val iosTest by creating {
//            dependsOn(commonTest)
//            iosX64Test.dependsOn(this)
//            iosArm64Test.dependsOn(this)
//            iosSimulatorArm64Test.dependsOn(this)
//        }
    }
}

android {
    namespace = "com.ktxdevelopment.siratimustakim"
    compileSdk = Versions.compileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.minSdk
    }
}
dependencies {
    implementation("com.google.firebase:protolite-well-known-types:18.0.0")
}

sqldelight {
    database("PostDatabase") {
        packageName = "com.ktxdevelopment.siratimustakim.shared.sqldelight"
        sourceFolders = listOf("sqldelight")
    }
}