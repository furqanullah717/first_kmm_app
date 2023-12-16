package com.codewithfk.firstappkmm.sleep_app.data

import com.codewithfk.firstappkmm.shared.db.AppDatabase
import com.codewithfk.firstappkmm.sleep_app.domain.TimeDataSource
import com.codewithfk.firstappkmm.sleep_app.model.SleepModel
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.supervisorScope

class TimeDataSourceImpl(appDatabase: AppDatabase) : TimeDataSource {
    private val queries = appDatabase.timeQueries
    override fun getSleepData(): Flow<List<SleepModel>> {
        return queries.getAllTimeDesc().asFlow()
            .mapToList()
            .map { contactEntities ->
                supervisorScope {
                    contactEntities
                        .map {
                            async {
                                SleepModel(
                                    id = it.id,
                                    startTime = it.startTime,
                                    endTime = it.endTime,
                                    date = it.date
                                )
                            }
                        }.map { it.await() }
                }
            }
    }

    override fun getSleepDataFromRange(startDate: Long, endDate: Long): Flow<List<SleepModel>> {
        return queries.getAllTime(startDate, endDate).asFlow()
            .mapToList()
            .map { contactEntities ->
                supervisorScope {
                    contactEntities
                        .map {
                            async {
                                SleepModel(
                                    id = it.id,
                                    startTime = it.startTime,
                                    endTime = it.endTime,
                                    date = it.date
                                )
                            }
                        }.map { it.await() }
                }
            }
    }

    override fun getAllDataDesc(): Flow<List<SleepModel>> {
        return queries.getAllTimeDesc().asFlow()
            .mapToList()
            .map { contactEntities ->
                supervisorScope {
                    contactEntities
                        .map {
                            async {
                                SleepModel(
                                    id = it.id,
                                    startTime = it.startTime,
                                    endTime = it.endTime,
                                    date = it.date
                                )
                            }
                        }.map { it.await() }
                }
            }
    }

    override suspend fun insertSleepData(sleepModel: SleepModel) {
        queries.addSleepTime(
            id = sleepModel.id,
            date = sleepModel.date,
            startTime = sleepModel.startTime,
            endTime = sleepModel.endTime
        )
    }

    override suspend fun deleteSleepData(id: Long) {
        queries.deletSleepEntry(id)
    }
}