package com.codewithfk.firstappkmm.core.data

import com.squareup.sqldelight.db.SqlDriver

expect class SqlDelightDriverFactory {
    fun createDriver(): SqlDriver
}