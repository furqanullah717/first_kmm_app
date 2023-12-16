package com.codewithfk.firstappkmm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.codewithfk.firstappkmm.di.AppModule
import com.codewithfk.firstappkmm.sleep_app.model.SleepModel
import com.codewithfk.firstappkmm.sleep_app.ui.home.HomeScreen
import kotlinx.coroutines.launch
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import kotlin.random.Random

@Composable
fun AppComposeView(appModule: AppModule) {

    PreComposeApp {
        val navController = rememberNavigator()
        val coroutineScope = rememberCoroutineScope()
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navigator = navController,
            initialRoute = "home"
        ) {
            scene("home") {
                HomeScreen(appModule)
            }
            scene("screen1") {
                Screen1(navController)
            }
            scene("screen2") {
                Screen2(navController)
            }
        }
    }

}