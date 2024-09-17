package com.example.krishibazaar.Presentation.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.krishibazaar.Data.Item.itemData
import com.example.krishibazaar.R

@Composable
fun SaleItemCard(item: itemData, onClickToDetailScreen:(itemData) -> Unit) {
    val filledStarPainter = painterResource(id = R.drawable.cool_star)
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onClickToDetailScreen(item) }
            .fillMaxWidth()
        //elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            //verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = item.painter,
                contentDescription = item.name,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RectangleShape)
            )
//            AsyncImage(
//                model = item.imageUrl,
//                contentDescription = item.name,
//                modifier = Modifier
//                    .size(64.dp)
//                    .clip(CircleShape)
//            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.name, style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    Text(
                        text = "\u20B9 ${item.salePrice} / kg  ",
                        style = MaterialTheme
                            .typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        //modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = item.originalPrice.toString(),
                        style = MaterialTheme.typography.labelLarge,
                        textDecoration = TextDecoration.LineThrough,
                        //modifier = Modifier.padding(8.dp)
                    )
                }
                RatingBar(
                    currentRating = item.stars,
                    filledStar = filledStarPainter,
                    style = MaterialTheme.typography.labelSmall,
                    startPadding = 0,
                    show = false
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onClickToHomeScreen: () -> Unit,
    onClickToDetailScreen: (itemData) -> Unit,
    SampleItems: List<itemData>
    //saleItems: List<itemData>
){


    Scaffold(
        topBar =  {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { onClickToHomeScreen() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = colorResource(id = R.color.white)//MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                },
//             title =  {Text(stringResource(R.string.About_Screen))} ,
                title = { Text(text = "Krishi Bazaar") },
                actions = {
//                    IconButton(onClick = { /* Handle search icon click */ }) {
//                        Icon(
//                            imageVector = Icons.Default.Search,
//                            contentDescription = "Search",
//                            tint = MaterialTheme.colorScheme.inversePrimary
//                        )
//                    }
                    IconButton(onClick = { /* Handle login icon click */ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Login",
                            tint = colorResource(id = R.color.white)//MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.secondary,
//                    titleContentColor = MaterialTheme.colorScheme.inversePrimary,
                    containerColor = colorResource(id = R.color.teal_700),
                    titleContentColor = colorResource(id = R.color.white)
                )
            ) 
        }
        
    ){innerpadding->
        Spacer(modifier = Modifier.height(4.dp))
        val temp:String =""
        //OutlinedTextField(value = temp, onValueChange = {})
        Spacer(modifier = Modifier.height(4.dp))
        Column(
            Modifier.padding(innerpadding)
        ){
            OutlinedTextField(
                value = temp,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                label = { Text("Search...") }
            )
            Button(
                onClick = { onClickToHomeScreen() },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_700) // Customize the button color here
                )
            ) {
                Text(text = "Home")
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                //contentPadding = innerpadding
            ){
                items(SampleItems.size) { item ->
                    SaleItemCard(
                        item = SampleItems[item],
                        onClickToDetailScreen = onClickToDetailScreen
                    )
                }
            }

            //Spacer(modifier = Modifier.height(4.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SaleItemScreenPreview() {
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
    SearchScreen({},{}, sampleItems)
}