package com.arviejhay.secretboard.data.usecase

import com.arviejhay.secretboard.data.model.Post
import com.arviejhay.secretboard.data.repository.PostRepository

class SubmitPostUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(name: String?, title: String?, message: String): Post {
        return repository.submitPost(name, title, message)
    }
}