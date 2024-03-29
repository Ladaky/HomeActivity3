package com.example.homeactivity.screens.comments

import android.arch.lifecycle.LiveData
import com.example.homeactivity.data.FeedPostsRepository
import com.example.homeactivity.data.UsersRepository
import com.example.homeactivity.models.Comment
import com.example.homeactivity.models.User
import com.example.homeactivity.screens.common.BaseViewModel
import com.google.android.gms.tasks.OnFailureListener

class CommentsViewModel(private val feedPostsRepo: FeedPostsRepository,
                        usersRepo: UsersRepository,
                        onFailureListener: OnFailureListener
) :
    BaseViewModel(onFailureListener) {
    lateinit var comments: LiveData<List<Comment>>
    private lateinit var postId: String
    val user: LiveData<User> = usersRepo.getUser()

    fun init(postId: String) {
        this.postId = postId
        comments = feedPostsRepo.getComments(postId)
    }

    fun createComment(text: String, user: User) {
        val comment = Comment(
            uid = user.uid,
            username = user.username,
            photo = user.photo,
            text = text)
        feedPostsRepo.createComment(postId, comment).addOnFailureListener(onFailureListener)
    }
}