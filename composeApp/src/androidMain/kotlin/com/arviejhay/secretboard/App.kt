package com.arviejhay.secretboard

import androidx.compose.runtime.*

import com.arviejhay.secretboard.ViewModel.BoardViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    val viewModel: BoardViewModel = koinViewModel()

    Board(viewModel)
}