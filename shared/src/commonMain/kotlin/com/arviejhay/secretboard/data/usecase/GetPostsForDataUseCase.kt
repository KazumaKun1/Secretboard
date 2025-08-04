package com.arviejhay.secretboard.data.usecase

import com.arviejhay.secretboard.data.model.Post
import com.arviejhay.secretboard.data.repository.PostRepository

class GetPostsForDataUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(date: String): List<Post> {
        return repository.getPostsForDate(date)
    }
}