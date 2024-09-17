package com.example.krishibazaar.Data

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

// Create Navigation Items Class to Select Unselect items
data class NavigationItems(
    val title: String,
    val selectedIcon: ImageVector,
    val navigationRoute: Any? = null,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)