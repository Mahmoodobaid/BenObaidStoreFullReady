package com.benobaidstore.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

object GoogleAuthUtils {
    private const val RC_SIGN_IN = 1001

    fun getSignInClient(context: Context): GoogleSignInClient {
        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(context, options)
    }

    fun launchSignIn(activity: Activity) {
        val signInIntent = getSignInClient(activity).signInIntent
        activity.startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    fun handleSignInResult(task: Task<GoogleSignInAccount>): String? {
        return try {
            val account = task.getResult(ApiException::class.java)
            account?.email
        } catch (e: ApiException) {
            null
        }
    }

    fun signOut(context: Context) {
        getSignInClient(context).signOut()
    }
}