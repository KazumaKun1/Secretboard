package com.arviejhay.secretboard.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.arviejhay.secretboard.data.model.Post

@Composable
fun PostGrid(
    posts: List<Post>,
    modifier: Modifier = Modifier
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(1),
        verticalItemSpacing = 3.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(top = 4.dp),
        content = {
            items(posts) { post ->
                PostCard(post = post)
            }
        },
        modifier = modifier.fillMaxSize()
    )
}

