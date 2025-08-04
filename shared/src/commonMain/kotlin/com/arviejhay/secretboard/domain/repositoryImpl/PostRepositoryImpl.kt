package com.arviejhay.secretboard.domain.repositoryImpl

import com.arviejhay.secretboard.data.model.Post
import com.arviejhay.secretboard.data.repository.PostRepository
import com.arviejhay.secretboard.domain.api.PostApiService

class PostRepositoryImpl(
    private val api: PostApiService
) : PostRepository {
    override suspend fun getPostsForDate(date: String): List<Post> {
        return api.getPostsForDate(date)
    }

    override suspend fun submitPost(name: String?, title: String?, message: String): Post {
        return api.submitPost(name, title, message)
    }
}