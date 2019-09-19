package com.example.homeactivity.common.firebase


import com.example.homeactivity.common.AuthManager
import com.example.homeactivity.common.toUnit
import com.example.homeactivity.data.firebase.common.auth
import com.google.android.gms.tasks.Task


class FirebaseAuthManager : AuthManager {
    override fun signOut() {
        auth.signOut()

    }

    override fun signIn(email: String, password: String): Task<Unit> =
        auth.signInWithEmailAndPassword(email, password).toUnit()
}