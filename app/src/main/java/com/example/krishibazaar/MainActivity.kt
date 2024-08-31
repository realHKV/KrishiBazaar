package com.example.krishibazaar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.krishibazaar.Data.itemData
import com.example.krishibazaar.Navigation.navigation
import com.example.krishibazaar.Screens.HomeScreen
import com.example.krishibazaar.Screens.SearchScreen
import com.example.krishibazaar.ui.theme.KrishiBazaarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            KrishiBazaarTheme {

                myApp()
            }
        }
    }
}

@Composable
fun myApp(){
    val painter1: Painter = painterResource(id = R.drawable.doge)
    val painter2: Painter = painterResource(id = R.drawable.lud)
    val painter3: Painter = painterResource(id = R.drawable.no_maidens)
    val sampleItems = listOf(
        itemData(1, "Aloo (Potato)", painter1, 1000.0, 850.0),
        itemData(2, "Baingan (Eggplant)", painter1, 600.0, 450.0),
        itemData(3, "Gheeya (Ridge Gourd)", painter2, 200.0, 150.0),
        itemData(4, "Palak (Spinach)", painter1, 300.0, 250.0),
        itemData(5, "Mooli (Radish)", painter1, 180.0, 120.0),
        itemData(6, "Bhindi (Okra)", painter1, 400.0, 320.0),
        itemData(7, "Kaddu (Pumpkin)", painter1, 350.0, 280.0),
        itemData(8, "Gajar (Carrot)", painter3, 250.0, 200.0),
        itemData(9, "Masoor (Lentils)", painter3, 1200.0, 980.0),
        itemData(10, "Tractor", painter2, 150000.0, 130000.0)
    )
    navigation(sampleItems)
}
