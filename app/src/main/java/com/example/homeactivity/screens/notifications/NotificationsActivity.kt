package com.example.homeactivity.screens.notifications

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.homeactivity.R
import com.example.homeactivity.screens.common.BaseActivity
import com.example.homeactivity.screens.common.setupAuthGuard
import com.example.homeactivity.screens.common.setupBottomNavigation
import kotlinx.android.synthetic.main.activity_notifications.*

class NotificationsActivity : BaseActivity() {
    private lateinit var mAdapter: NotificationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
        Log.d(TAG, "onCreate")

        setupAuthGuard { uid ->
            setupBottomNavigation(uid,3)
            mAdapter = NotificationsAdapter()
            notifications_recycler.layoutManager = LinearLayoutManager(this)
            notifications_recycler.adapter = mAdapter

            val viewModel = initViewModel<NotificationsViewModel>()
            viewModel.init(uid)
            viewModel.notifications.observe(this, Observer {
                it?.let {
                    mAdapter.updateNotifications(it)
                    viewModel.setNotificationsRead(it)
                }
            })
        }
    }

    companion object {
        const val TAG = "LikesActivity"
    }
}