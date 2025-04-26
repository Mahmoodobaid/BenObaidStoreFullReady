package com.example.binubaidstore.ui.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.binubaidstore.ui.screens.*

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("home") {
            ProductListScreen()
        }
        composable("add") {
            AddProductScreen()
        }
        composable("about") {
            AboutScreen()
        }
    }
}
