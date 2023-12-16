package com.codewithfk.firstappkmm.core.data

import android.content.Context
import com.codewithfk.firstappkmm.shared.db.AppDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class SqlDelightDriverFactory (private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            AppDatabase.Schema,
            context,
            "time.db"
        )
    }
}