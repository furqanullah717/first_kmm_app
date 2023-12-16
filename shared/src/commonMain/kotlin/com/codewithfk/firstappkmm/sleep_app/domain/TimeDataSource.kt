package com.codewithfk.firstappkmm.sleep_app.domain

import com.codewithfk.firstappkmm.sleep_app.model.SleepModel
import kotlinx.coroutines.flow.Flow

interface TimeDataSource {

    fun getSleepData(): Flow<List<SleepModel>>

    fun getSleepDataFromRange(startDate: Long, endDate: Long): Flow<List<SleepModel>>

    fun getAllDataDesc(): Flow<List<SleepModel>>

    suspend fun insertSleepData(sleepModel: SleepModel)

    suspend fun deleteSleepData(id: Long)

}