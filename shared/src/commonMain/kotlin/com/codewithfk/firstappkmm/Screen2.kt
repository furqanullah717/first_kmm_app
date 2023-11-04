package com.codewithfk.firstappkmm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.stringResource
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun Screen2(navigator: Navigator) {
    Column(
        modifier = Modifier.background(Color.Black).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(MR.strings.screen2) , color = Color.White)
        Button(
            onClick = {
                navigator.popBackStack()
            }
        ){
            Text("Back")
        }
    }
}