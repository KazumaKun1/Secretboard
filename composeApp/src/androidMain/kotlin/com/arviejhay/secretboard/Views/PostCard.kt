package com.arviejhay.secretboard.Views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.arviejhay.secretboard.data.model.Post
import com.arviejhay.secretboard.data.model.formatAsDate

@Composable
fun PostCard(post: Post) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            post.title?.let {
                Text(text = post.title.toString(), style = MaterialTheme.typography.titleLarge)
            }
            Text(text = post.name.toString(),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(top = 2.dp))
            Text(text = post.message, style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp))
            Text(text = post.timestamp?.formatAsDate() ?: "", style = MaterialTheme.typography.bodySmall)
        }
    }
}