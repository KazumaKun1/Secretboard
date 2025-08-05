package com.arviejhay.secretboard.domain.api.Result

sealed class SubmitPostResult {
    object Success : SubmitPostResult()
    data class Failure(val exception: Exception) : SubmitPostResult()
}