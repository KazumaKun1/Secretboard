package com.arviejhay.secretboard.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arviejhay.secretboard.data.model.Post
import com.arviejhay.secretboard.data.usecase.GetPostsForDataUseCase
import com.arviejhay.secretboard.data.usecase.SubmitPostUseCase
import com.arviejhay.secretboard.domain.api.Result.GetPostResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BoardViewModel(
    private val getPosts: GetPostsForDataUseCase,
    private val submitPost: SubmitPostUseCase
) : ViewModel() {

    val posts = MutableStateFlow<List<Post>>(emptyList())
    val isLoading = MutableStateFlow(false)
    val hasAnError = MutableStateFlow(false)

    fun loadPosts(date: String) {
        hasAnError.value = false
        isLoading.value = true

        viewModelScope.launch {
            val result = getPosts(date)
            when (result) {
                is GetPostResult.Success -> posts.value = result.posts
                is GetPostResult.Failure -> posts.value = emptyList()
            }
            hasAnError.value = result is GetPostResult.Failure
            isLoading.value = false
        }
    }

    fun sendPost(name: String?, title: String?, message: String) {
        viewModelScope.launch {
            submitPost(name, title, message)
            loadPosts("2023-10-01")
        }
    }
}