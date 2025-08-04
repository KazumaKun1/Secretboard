package com.arviejhay.secretboard.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arviejhay.secretboard.data.model.Post
import com.arviejhay.secretboard.data.usecase.GetPostsForDataUseCase
import com.arviejhay.secretboard.data.usecase.SubmitPostUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BoardViewModel(
    private val getPosts: GetPostsForDataUseCase,
    private val submitPost: SubmitPostUseCase
) : ViewModel() {

    val posts = MutableStateFlow<List<Post>>(emptyList())

    fun loadPosts(date: String) {
        viewModelScope.launch {
            posts.value = getPosts(date)
        }
    }

    fun sendPost(name: String?, title: String?, message: String) {
        viewModelScope.launch {
            submitPost(name, title, message)
        }
    }
}