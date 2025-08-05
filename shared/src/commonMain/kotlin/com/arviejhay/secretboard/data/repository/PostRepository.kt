package com.arviejhay.secretboard.data.repository

import com.arviejhay.secretboard.domain.api.Result.GetPostResult
import com.arviejhay.secretboard.domain.api.Result.SubmitPostResult

interface PostRepository {
    suspend fun getPostsForDate(date: String): GetPostResult
    suspend fun submitPost(name: String?,
                           title: String?,
                           message: String): SubmitPostResult
}