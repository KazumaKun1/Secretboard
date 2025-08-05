package com.arviejhay.secretboard.domain.repositoryImpl

import com.arviejhay.secretboard.data.model.Post
import com.arviejhay.secretboard.data.repository.PostRepository
import com.arviejhay.secretboard.domain.api.PostApiService
import com.arviejhay.secretboard.domain.api.Result.GetPostResult
import com.arviejhay.secretboard.domain.api.Result.SubmitPostResult

class PostRepositoryImpl(
    private val api: PostApiService
) : PostRepository {
    override suspend fun getPostsForDate(date: String): GetPostResult {
        return api.getPostsForDate(date)
    }

    override suspend fun submitPost(name: String?, title: String?, message: String): SubmitPostResult {
        return api.submitPost(name, title, message)
    }
}