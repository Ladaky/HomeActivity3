package com.example.homeactivity.screens.profilesettings

import com.example.homeactivity.common.AuthManager
import com.example.homeactivity.screens.common.BaseViewModel
import com.google.android.gms.tasks.OnFailureListener

class ProfileSettingsViewModel(private val authManager: AuthManager,
                               onFailureListener: OnFailureListener
) :
    BaseViewModel(onFailureListener),
    AuthManager by authManager