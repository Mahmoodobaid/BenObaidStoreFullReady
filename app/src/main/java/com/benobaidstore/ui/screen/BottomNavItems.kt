package com.benobaidstore.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.benobaidstore.ui.components.BottomNavItem

object BottomNavItems {
    val items = listOf(
        BottomNavItem("home", Icons.Default.Home, "الرئيسية"),
        BottomNavItem("add", Icons.Default.Add, "إضافة"),
        BottomNavItem("about", Icons.Default.Info, "حول")
    )
}