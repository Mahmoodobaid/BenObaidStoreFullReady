package com.benobaidstore.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.benobaidstore.utils.GoogleAuthUtils
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    val activity = context as Activity
    var userEmail by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        val account = GoogleSignIn.getLastSignedInAccount(context)
        if (account != null) {
            userEmail = account.email
            navController.navigate("home") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "متجر بن عبيد", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { GoogleAuthUtils.launchSignIn(activity) }) {
                    Text("تسجيل الدخول بحساب Google")
                }
            }
        }
    }
}