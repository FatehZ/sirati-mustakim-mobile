package com.ktxdevelopment.siratimustakim.datasource.cache

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(PostDatabase.Schema, context, "post.db")
    }
}