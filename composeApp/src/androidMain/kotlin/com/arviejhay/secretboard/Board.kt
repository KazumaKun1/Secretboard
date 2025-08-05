package com.arviejhay.secretboard

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment

import androidx.compose.material3.pulltorefresh.PullToRefreshBox

import com.arviejhay.secretboard.ViewModel.BoardViewModel

import com.arviejhay.secretboard.Views.PostGrid
import com.arviejhay.secretboard.Views.LoadingIndicator
import com.arviejhay.secretboard.Views.AddPostDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Board(viewModel: BoardViewModel) {
    val posts by viewModel.posts.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val hasAnError by viewModel.hasAnError.collectAsState()
    var showAddDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.loadPosts("2023-10-01")
    }

    Column(modifier = Modifier.background(Color.LightGray)) {
        CenterAlignedTopAppBar(
            title = { Text(text = "Secret Board") },
            actions = {
                IconButton(
                    onClick = {
                        showAddDialog = true
                    }
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }
        )

        AddPostDialog(
            showDialog = showAddDialog,
            onDismiss = { showAddDialog = false },
            onSubmit = { name, title, message ->
                viewModel.sendPost(name, title, message)
            }
        )

        if (isLoading) {
            LoadingIndicator()
        } else {
            PullToRefreshBox(
                isRefreshing = isLoading,
                onRefresh = { viewModel.loadPosts("2023-10-01") },
                modifier = Modifier.fillMaxSize()
            ) {
                if (hasAnError) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "An error occurred while loading posts. Please pull the page to try again.")
                    }
                } else {
                    PostGrid(posts = posts)
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}