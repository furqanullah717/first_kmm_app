package com.codewithfk.firstappkmm.sleep_app.ui.home

import com.codewithfk.firstappkmm.sleep_app.domain.TimeDataSource
import com.codewithfk.firstappkmm.sleep_app.model.SleepModel
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val dataSource: TimeDataSource) : ViewModel() {
    fun addEntry(sleepModel: SleepModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dataSource.insertSleepData(sleepModel)
        }
    }

    private val _state = dataSource.getSleepData()
    val state: Flow<List<SleepModel>> = _state

}