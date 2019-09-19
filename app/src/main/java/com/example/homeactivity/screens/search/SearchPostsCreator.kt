package com.example.homeactivity.screens.search

import android.arch.lifecycle.Observer
import android.util.Log
import com.example.homeactivity.common.BaseEventListener
import com.example.homeactivity.common.Event
import com.example.homeactivity.common.EventBus
import com.example.homeactivity.data.SearchRepository
import com.example.homeactivity.models.SearchPost

class SearchPostsCreator(searchRepo: SearchRepository) : BaseEventListener() {
    init {
        EventBus.events.observe(this, Observer {
            it?.let { event ->
                when (event) {
                    is Event.CreateFeedPost -> {
                        val searchPost = with(event.post) {
                            SearchPost(
                                image = image,
                                caption = caption,
                                postId = id)
                        }
                        searchRepo.createPost(searchPost).addOnFailureListener {
                            Log.d(TAG, "Failed to create search post for event: $event", it)
                        }
                    }
                    else -> {
                    }
                }
            }
        })
    }

    companion object {
        const val TAG = "SearchPostsCreator"
    }
}