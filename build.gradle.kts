plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.0.1").apply(false)
    id("com.android.library").version("8.0.1").apply(false)
//    id("app.cash.sqldelight").version("2.0.0-alpha05")
    kotlin("android").version("1.8.21").apply(false)
    kotlin("multiplatform").version("1.8.21").apply(false)
}

buildscript {
    // ...
    val sqlDelightVersion = "1.5.5"

    dependencies {
        // ...
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
    }
}


//sqldelight {
//    databases {
//        create("Database") {
//            packageName.set("com.example")
//        }
//    }
//}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}