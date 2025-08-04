package com.arviejhay.secretboard.domain.api

import com.arviejhay.secretboard.data.model.Post

interface PostApiService {
    suspend fun getPostsForDate(date: String): List<Post>
    suspend fun submitPost(name: String?,
                           title: String?,
                           message: String): Post
}