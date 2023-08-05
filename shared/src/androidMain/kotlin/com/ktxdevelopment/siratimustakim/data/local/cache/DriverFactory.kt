package com.ktxdevelopment.siratimustakim.data.local.cache

import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(PostDatabase.Schema, "post.db")
    }
}