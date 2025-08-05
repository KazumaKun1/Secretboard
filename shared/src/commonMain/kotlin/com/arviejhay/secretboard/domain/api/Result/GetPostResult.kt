package com.arviejhay.secretboard.domain.api.Result

import com.arviejhay.secretboard.data.model.Post

sealed class GetPostResult {
    data class Success(val posts: List<Post>) : GetPostResult()
    data class Failure(val exception: Exception) : GetPostResult()
}