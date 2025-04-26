package com.benobaidstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.benobaidstore.ui.navigation.AppNavigation
import com.benobaidstore.ui.components.BottomNavigationBar
import com.benobaidstore.ui.screens.BottomNavItems
import com.benobaidstore.ui.theme.BenObaidStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BenObaidStoreTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                navController = navController,
                                items = BottomNavItems.items
                            )
                        }
                    ) {
                        AppNavigation(navController = navController)
                    }
                }
            }
        }
    }
}