package com.ktxdevelopment.siratimustakim.data.local.cache

import com.ktxdevelopment.siratimustakim.shared.sqldelight.PostDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory() {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(PostDatabase.Schema, "post.db")
    }
}