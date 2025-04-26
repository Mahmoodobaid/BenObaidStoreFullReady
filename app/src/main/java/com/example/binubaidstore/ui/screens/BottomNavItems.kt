package com.example.binubaidstore.ui.screens


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import com.benobaidstore.ui.components.BottomNavItem

object BottomNavItems {
    val items = listOf(
        BottomNavItem(route = "home", icon = Icons.Default.Home, label = "الرئيسية"),
        BottomNavItem(route = "add", icon = Icons.Default.Add, label = "إضافة"),
        BottomNavItem(route = "about", icon = Icons.Default.Info, label = "حول التطبيق")
    )
}