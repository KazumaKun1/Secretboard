package com.arviejhay.secretboard.data.usecase

import com.arviejhay.secretboard.data.repository.PostRepository

import com.arviejhay.secretboard.domain.api.Result.SubmitPostResult

class SubmitPostUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(name: String?, title: String?, message: String): SubmitPostResult {
        return repository.submitPost(name, title, message)
    }
}