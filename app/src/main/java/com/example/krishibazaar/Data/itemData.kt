package com.example.krishibazaar.Data

import androidx.compose.ui.graphics.painter.Painter

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