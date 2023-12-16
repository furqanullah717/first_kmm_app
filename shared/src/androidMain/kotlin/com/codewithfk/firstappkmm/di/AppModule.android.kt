package com.codewithfk.firstappkmm.di

import android.content.Context
import com.codewithfk.firstappkmm.core.data.SqlDelightDriverFactory
import com.codewithfk.firstappkmm.shared.db.AppDatabase
import com.codewithfk.firstappkmm.sleep_app.data.TimeDataSourceImpl
import com.codewithfk.firstappkmm.sleep_app.domain.TimeDataSource

actual class AppModule(private val context: Context) {
    actual val sleepDataSource: TimeDataSource
        get() = TimeDataSourceImpl(AppDatabase.invoke(SqlDelightDriverFactory(context).createDriver()))
}