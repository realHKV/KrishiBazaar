package com.example.krishibazaar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.krishibazaar.Data.Item.itemData
import com.example.krishibazaar.Navigation.navigation
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


    val sampleItems = listOf(
        itemData(
            id = 1,
            name = "Aloo (Potato)",
            soldBy = "Shankar Singh Gaonwala",
            stars = 5,
            description = "Fresh, organic potatoes from my farm. Perfect for curries, fries, or a hearty aloo paratha. Grown with love and minimal use of chemicals.",
            painter = painterResource(id = R.drawable.wa_potato),
            originalPrice = 100.0,
            salePrice = 85.0
        ),
        itemData(
            id = 2,
            name = "Baingan (Eggplant)",
            soldBy = "Girdharilal Yadav",
            stars = 4,
            description = "Plump and shiny eggplants, ready to be roasted or turned into a delicious baingan bharta. Grown in the rich soil of my village farm.",
            painter = painterResource(id = R.drawable.wa_baingan),
            originalPrice = 60.0,
            salePrice = 45.0
        ),
        itemData(
            id = 3,
            name = "Gheeya (Ridge Gourd)",
            soldBy = "Kamala Devi",
            stars = 4,
            description = "Tender and fresh gheeya, ideal for light curries and stews. Handpicked from my garden every morning to ensure the best quality.",
            painter = painterResource(id = R.drawable.wa_gheeya),
            originalPrice = 20.0,
            salePrice = 15.0
        ),
        itemData(
            id = 4,
            name = "Palak (Spinach)",
            soldBy = "Ramprasad Sharma",
            stars = 5,
            description = "Green and leafy spinach, full of iron and freshness. My palak is a favorite for making saag, palak paneer, or a healthy salad.",
            painter = painterResource(id = R.drawable.wa_palak),
            originalPrice = 30.0,
            salePrice = 25.0
        ),
        itemData(
            id = 5,
            name = "Mooli (Radish)",
            soldBy = "Ramesh Kumar",
            stars = 4,
            description = "Crisp and spicy radishes, perfect for a winter salad or to add crunch to your meals. Grown in our family farm using traditional methods.",
            painter = painterResource(id = R.drawable.wa_mooli),
            originalPrice = 18.0,
            salePrice = 12.0
        ),
        itemData(
            id = 6,
            name = "Bhindi (Okra)",
            soldBy = "Suresh Kisan",
            stars = 5,
            description = "Fresh bhindi, known for its tenderness and perfect for making bhindi fry or curry. Straight from my fields to your kitchen.",
            painter = painterResource(id = R.drawable.wa_bhindi),
            originalPrice = 40.0,
            salePrice = 32.0
        ),
        itemData(
            id = 7,
            name = "Kaddu (Pumpkin)",
            soldBy = "Bhawani Shankar",
            stars = 4,
            description = "Sweet and ripe pumpkin, great for making soups, curries, or even desserts. Harvested at the peak of its sweetness.",
            painter = painterResource(id = R.drawable.wa_kaddu),
            originalPrice = 35.0,
            salePrice = 28.0
        ),
        itemData(
            id = 8,
            name = "Gajar (Carrot)",
            soldBy = "Laxmi Narayan",
            stars = 5,
            description = "Bright orange carrots, crunchy and sweet. Perfect for salads, juices, or traditional halwa. Grown in my small farm with care.",
            painter = painterResource(id = R.drawable.wa_carrot),
            originalPrice = 25.0,
            salePrice = 20.0
        ),
        itemData(
            id = 9,
            name = "Masoor (Lentils)",
            soldBy = "Hari Singh",
            stars = 5,
            description = "High-quality masoor dal, perfect for daily cooking. These lentils are rich in protein and have been hand-sorted for the best quality.",
            painter = painterResource(id = R.drawable.masoor),
            originalPrice = 120.0,
            salePrice = 98.0
        ),
        itemData(
            id = 10,
            name = "Tractor",
            soldBy = "Rajendra Mechanic",
            stars = 4,
            description = "A reliable tractor, perfect for plowing and other farm activities. Well-maintained and ready to serve your agricultural needs.",
            painter = painterResource(id = R.drawable.tractor),
            originalPrice = 150.0,
            salePrice = 130.0
        )
    )
    navigation(sampleItems)
    //DetailScreen(item = sampleItems.first())
}
