//buildscript {
//    dependencies {
//        classpath("com.squareup.sqldelight:gradle-plugin:1.5.5")
//        classpath("com.android.tools.build:gradle:8.0.2")
////        classpath("com.android.tools.build:gradle:8.1.0-rc01")
//    }
//}
plugins {
    //trick: for the same plugin versions in all sub-modules
//    id("com.android.application").version("8.0.2").apply(false)
//    id("com.android.library").version("8.0.2").apply(false)
//    kotlin("android").version("1.8.21").apply(false)
//    kotlin("multiplatform").version("1.8.21").apply(false)

//    id("com.android.application").apply(false)
//    kotlin("android").apply(false)
//    kotlin("multiplatform").apply(false)
//    id("com.android.library").apply(false)
//    id("org.jetbrains.compose").apply(false)

    id("com.android.application") version Versions.gradle apply false
    id("com.android.library") version Versions.gradle apply false
    id("com.squareup.sqldelight") version Versions.sqlDelight apply false
    kotlin("android") version Versions.kotlin apply false
    kotlin("multiplatform") version Versions.kotlin apply false
    kotlin("plugin.serialization") version Versions.kotlin apply false

}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}