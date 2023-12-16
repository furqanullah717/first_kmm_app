package com.codewithfk.firstappkmm.di

import com.codewithfk.firstappkmm.sleep_app.domain.TimeDataSource

expect class AppModule {
    val sleepDataSource: TimeDataSource
}