package com.benobaidstore.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.benobaidstore.utils.DriveSyncUtils
import com.google.android.gms.auth.api.signin.GoogleSignIn

@Composable
fun AboutScreen() {
    val context = LocalContext.current
    val account = GoogleSignIn.getLastSignedInAccount(context)

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("محلات بن عبيد التجارية", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text("اليمن - إب - شارع المحافظة")
            Text("مبيعات: 782999654")
            Text("حسابات: 782999652")
            Text("مبيعات جملة: 782999653")
            Text("واتساب: +967770491653")
            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
                if (account != null) {
                    DriveSyncUtils.initDriveService(context, account.email ?: "")
                    DriveSyncUtils.uploadDatabase(context)
                }
            }) {
                Text("مزامنة البيانات مع Google Drive")
            }
        }
    }
}