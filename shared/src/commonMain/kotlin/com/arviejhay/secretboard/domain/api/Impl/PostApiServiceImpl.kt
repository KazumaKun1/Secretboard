package com.arviejhay.secretboard.domain.api.Impl

import com.arviejhay.secretboard.data.model.Post

import com.arviejhay.secretboard.domain.api.Result.GetPostResult
import com.arviejhay.secretboard.domain.api.Result.SubmitPostResult

import com.arviejhay.secretboard.domain.api.PostApiService

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.firestore.Timestamp
import dev.gitlive.firebase.firestore.toMilliseconds

import com.arviejhay.secretboard.domain.api.Impl.PostFields

class PostApiServiceImpl : PostApiService {
    val firestore = Firebase.firestore

    override suspend fun getPostsForDate(date: String): GetPostResult {
        try {
            val userResponse =
                firestore.collection("POSTS").get()
            val posts = userResponse.documents.map { doc ->
                val timestamp = (doc.get(PostFields.TIMESTAMP) as? Timestamp)?.toMilliseconds()?.toLong()
                Post(
                    id = doc.get(PostFields.ID) as? String ?: doc.id,
                    name = doc.get(PostFields.NAME) as? String,
                    title = doc.get(PostFields.TITLE) as? String,
                    message = doc.get(PostFields.MESSAGE) as? String ?: "",
                    timestamp = timestamp
                )
            }
            return GetPostResult.Success(posts)
        } catch (e: Exception) {
            return GetPostResult.Failure(e)
        }
    }

    override suspend fun submitPost(name: String?, title: String?, message: String): SubmitPostResult {
        try {
            val postMap = mapOf(
                PostFields.NAME to (if (name.isNullOrEmpty()) "Anonymous" else name),
                PostFields.TITLE to title,
                PostFields.MESSAGE to message,
                PostFields.TIMESTAMP to Timestamp.now()
            )
            val docRef = firestore.collection("POSTS").add(postMap)
            return SubmitPostResult.Success
        } catch (e: Exception) {
            return SubmitPostResult.Failure(e)
        }
    }
}
