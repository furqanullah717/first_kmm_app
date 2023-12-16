package com.codewithfk.firstappkmm

import androidx.compose.ui.window.ComposeUIViewController
import com.codewithfk.firstappkmm.di.AppModule


fun MainViewController() = ComposeUIViewController {
    AppComposeView(AppModule())
}