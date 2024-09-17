package com.example.krishibazaar.Data.Item

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.painter.Painter

@Immutable
data class itemData(
    val id: Int,
    val name: String,
    val soldBy: String,
    val stars : Int,
    val description: String,
    val painter: Painter,
    val originalPrice: Double,
    val salePrice: Double
)

@Immutable
data class onlineItemData(
    val id: String,
    val name: String?,
    val soldBy: String,
    val description: String?,
    val category: String?,
    val imageUrl: String?,
    val originalPrice: Double?=null,
    val salePrice: Double?,
    val rateType: String?
)