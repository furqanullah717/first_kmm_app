package com.codewithfk.firstappkmm.di

import com.codewithfk.firstappkmm.core.data.SqlDelightDriverFactory
import com.codewithfk.firstappkmm.shared.db.AppDatabase
import com.codewithfk.firstappkmm.sleep_app.data.TimeDataSourceImpl
import com.codewithfk.firstappkmm.sleep_app.domain.TimeDataSource

actual class AppModule {
    actual val sleepDataSource: TimeDataSource
        get() = TimeDataSourceImpl(AppDatabase.invoke(SqlDelightDriverFactory().createDriver()))
}