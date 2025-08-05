package com.arviejhay.secretboard.data.usecase

import com.arviejhay.secretboard.data.model.Post
import com.arviejhay.secretboard.data.repository.PostRepository

import com.arviejhay.secretboard.domain.api.Result.GetPostResult

class GetPostsForDataUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(date: String): GetPostResult {
        return repository.getPostsForDate(date)
    }
}