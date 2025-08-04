package com.arviejhay.secretboard.domain.api.Impl

import com.arviejhay.secretboard.data.model.Post
import com.arviejhay.secretboard.domain.api.PostApiService
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.firestore.Timestamp
import dev.gitlive.firebase.firestore.toMilliseconds

class PostApiServiceImpl : PostApiService {
    override suspend fun getPostsForDate(date: String): List<Post> {
        val firestore = Firebase.firestore

        try {
            val userResponse =
                firestore.collection("POSTS").get()
            return userResponse.documents.map { doc ->
                val timestamp = (doc.get("timestamp") as? Timestamp)?.toMilliseconds()?.toLong()
                Post(
                    id = doc.get("id") as? String ?: doc.id,
                    name = doc.get("name") as? String,
                    title = doc.get("title") as? String,
                    message = doc.get("message") as? String ?: "",
                    timestamp = timestamp
                )
            }
        } catch (e: Exception) {
            print(e.message)
            return emptyList() // Return empty list on error
        }
    }

    override suspend fun submitPost(name: String?, title: String?, message: String): Post {
        // Implementation for submitting a post
        return Post(
            id = "1", // Placeholder ID
            name = name,
            title = title,
            message = message,
            timestamp = null
        ) // Placeholder implementation
    }
}
