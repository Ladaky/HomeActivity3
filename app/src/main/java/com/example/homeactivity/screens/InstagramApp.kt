package com.example.homeactivity.screens

import android.app.Application
import com.example.homeactivity.common.firebase.FirebaseAuthManager
import com.example.homeactivity.data.firebase.FirebaseFeedPostsRepository
import com.example.homeactivity.data.firebase.FirebaseNotificationsRepository
import com.example.homeactivity.data.firebase.FirebaseSearchRepository
import com.example.homeactivity.data.firebase.FirebaseUsersRepository
import com.example.homeactivity.screens.notifications.NotificationsCreator
import com.example.homeactivity.screens.search.SearchPostsCreator

class InstagramApp : Application() {
    val usersRepo by lazy { FirebaseUsersRepository() }
    val feedPostsRepo by lazy { FirebaseFeedPostsRepository() }
    val notificationsRepo by lazy { FirebaseNotificationsRepository() }
    val authManager by lazy { FirebaseAuthManager() }
    val searchRepo by lazy { FirebaseSearchRepository() }

    override fun onCreate() {
        super.onCreate()
        NotificationsCreator(notificationsRepo, usersRepo, feedPostsRepo)
        SearchPostsCreator(searchRepo)
    }
}