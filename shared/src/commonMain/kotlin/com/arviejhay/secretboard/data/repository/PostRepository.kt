package com.arviejhay.secretboard.data.repository

import com.arviejhay.secretboard.data.model.Post

interface PostRepository {
    suspend fun getPostsForDate(date: String): List<Post>
    suspend fun submitPost(name: String?,
                           title: String?,
                           message: String): Post
}