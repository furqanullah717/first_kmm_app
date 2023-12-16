package com.codewithfk.firstappkmm.sleep_app.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.codewithfk.firstappkmm.di.AppModule
import com.codewithfk.firstappkmm.sleep_app.model.SleepModel
import dev.icerock.moko.mvvm.compose.ViewModelFactory
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import kotlin.random.Random


@Composable
fun HomeScreen(appModule: AppModule) {
    val viewModel = getViewModel(
        "HomeScreen",
        factory = viewModelFactory { HomeViewModel(appModule.sleepDataSource) })
    val state = viewModel.state.collectAsState(listOf())
    LazyColumn {
        items(state.value) { item ->
            Text(item.date.toString())
        }

        item {
            Button(onClick = {
                viewModel.addEntry(
                    SleepModel(
                        null,
                        Random.nextLong(),
                        Random.nextLong(),
                        Random.nextLong()
                    )
                )
            }) {
                Text("Add Entry")
            }
        }
    }

}