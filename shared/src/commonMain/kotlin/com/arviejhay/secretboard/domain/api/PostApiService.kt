package com.arviejhay.secretboard.domain.api

import com.arviejhay.secretboard.domain.api.Result.GetPostResult
import com.arviejhay.secretboard.domain.api.Result.SubmitPostResult

interface PostApiService {
    suspend fun getPostsForDate(date: String): GetPostResult
    suspend fun submitPost(name: String?,
                           title: String?,
                           message: String): SubmitPostResult
}