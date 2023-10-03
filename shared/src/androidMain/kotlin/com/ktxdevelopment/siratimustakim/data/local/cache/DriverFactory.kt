package com.ktxdevelopment.siratimustakim.data.local.cache

import android.content.Context
import com.ktxdevelopment.siratimustakim.shared.sqldelight.PostDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(PostDatabase.Schema, context, "post.db")
    }
}