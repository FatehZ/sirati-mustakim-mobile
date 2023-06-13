pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("app.cash.sqldelight") version "2.0.0-alpha05"
}


dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Sirati_Mustakim"
include(":androidApp")
include(":shared")