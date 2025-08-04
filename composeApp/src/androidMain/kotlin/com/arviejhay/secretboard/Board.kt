package com.arviejhay.secretboard

import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.PaddingValues

import com.arviejhay.secretboard.ViewModel.BoardViewModel
import com.arviejhay.secretboard.data.model.formatAsDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Board(viewModel: BoardViewModel) {
    val posts by viewModel.posts.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadPosts("2023-10-01") // Example date, replace with actual date logic
    }

    Column(modifier = Modifier.background(Color.LightGray)) {
        CenterAlignedTopAppBar(
            title = { Text(text = "Secret Board") }
        )

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(1),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(top = 4.dp),
            content = {
                items(posts) { post ->
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                        ) {
                            Text(text = post.name.toString(), style = MaterialTheme.typography.titleMedium)
                            Text(text = post.title.toString(), style = MaterialTheme.typography.titleSmall)
                            Text(text = post.message, style = MaterialTheme.typography.bodyMedium)
                            Text(text = post.timestamp?.formatAsDate() ?: "", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxSize()
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}