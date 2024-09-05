package com.example.krishibazaar.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.alignBy
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krishibazaar.Data.itemData
import com.example.krishibazaar.R
import com.example.krishibazaar.ui.Bot
import com.example.krishibazaar.ui.Category
import com.example.krishibazaar.ui.Sell
import com.example.krishibazaar.ui.TractorIcon

//import com.example.krishibazaar.uiElements.HomeScreenItemCard
//import com.example.krishibazaar.uiElements.HomeScreenItemCard
//import com.example.krishibazaar.uiElements.ItemCard


@Composable
fun CircularButton(icon: @Composable () -> Unit, text: String, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Button(
            onClick = onClick,
            shape = CircleShape,
            elevation =  ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 30.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            ) ,
            border = BorderStroke(1.dp, colorResource(id = R.color.white)),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.teal_700), // Set the background color here
                contentColor = Color.Red // Set the text/icon color here
            )
            ,
            modifier = Modifier
                .wrapContentSize()
                //.size(90.dp)
                .shadow(elevation = 10.dp, shape = CircleShape)
                .padding(8.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                icon()
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(text = text, fontSize = 12.sp, color = Color.White)
            }
        }
        Text(
            text = text,
            fontSize = 12.sp,
            color = Color.Black ,

        )
    }

}

@Composable
fun OutlinedCardExample() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .shadow(elevation = 64.dp, shape = RectangleShape)
            //.background(shape = RectangleShape)
            .padding(20.dp)
            .fillMaxWidth()
            .height(150.dp)
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.greetingbig),
            contentDescription = "item.name",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier

                .fillMaxSize()
                //.size(width = 1000.dp, height = 150.dp)
                .clip(RectangleShape)
        )
//        Text(
//            text = "idk",
//            modifier = Modifier
//                .padding(16.dp),
//            textAlign = TextAlign.Center,
//        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClickToSearchScreen: () -> Unit,
    onClickToDetailScreen: (itemData) -> Unit,
    onClickToChatbot: () -> Unit,
    onClickToRent: () -> Unit,
    onClickToCart: () -> Unit,
    onClickToSell: () -> Unit,
    onClickToLocation: () -> Unit,
    onClickToAboutScreen: () -> Unit,
    onClickToCategoryScreen: () -> Unit,
    SampleItems: List<itemData>
) {


    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
         CenterAlignedTopAppBar(
             navigationIcon = {
                 IconButton(onClick = { /*TODO*/ }) {
                     Icon(
                         imageVector = Icons.AutoMirrored.Filled.List,
                         contentDescription = "Localized description",
                         tint = colorResource(id = R.color.white)//MaterialTheme.colorScheme.inversePrimary
                     )
                 }
             },
//             title =  {Text(stringResource(R.string.About_Screen))} ,
             title = { Text(text = "Krishi Bazaar") },
             actions = {
                 IconButton(onClick = { onClickToSearchScreen() }) {
                     Icon(
                         imageVector = Icons.Default.Search,
                         contentDescription = "Search",
                         tint = colorResource(id = R.color.white)//MaterialTheme.colorScheme.inversePrimary
                     )
                 }
                 IconButton(onClick = { onClickToAboutScreen() }) {
                     Icon(
                         imageVector = Icons.Default.AccountCircle,
                         contentDescription = "Login",
                         tint = colorResource(id = R.color.white)//MaterialTheme.colorScheme.inversePrimary
                     )
                 }
             },
             colors = TopAppBarDefaults.topAppBarColors(
//                 containerColor = MaterialTheme.colorScheme.secondary,
//                 titleContentColor = MaterialTheme.colorScheme.inversePrimary,
                 containerColor = colorResource(id = R.color.teal_700),
                 titleContentColor = colorResource(id = R.color.white)
             )
         ) },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .verticalScroll(scrollState)
            //.fillMaxSize()
            ,
            //horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Top
        ){
            //Spacer(modifier = Modifier.height(16.dp))
            OutlinedCardExample()
            ///val tractorIcon: ImageVector = rememberVectorPainter(image = R.drawable.tractor_icon)


            val icons = listOf(
                Icons.Default.LocationOn,
                Category,
                Bot,
                TractorIcon,
                Icons.Default.ShoppingCart,
                Sell
            )
            val iconDescriptions = listOf(
                "Near You","Categories", "Ai Chatbot", "Rent", "Buy", "Sell"
            )
            //"CartX","Ai ChatbotX","Near YouX","AccountX","Mandi RatesX", "SettingsX",
            val navigationActions = listOf(
                { onClickToLocation() },
                { onClickToCategoryScreen() },
                { onClickToChatbot() },  // Ai Chatbot
                { onClickToRent() },     // Rent
                { onClickToCart() },      // Buy
                { onClickToSell() }      // Sell
            )
            Box(
                modifier = Modifier
                    //.wrapContentHeight()
                    .height(250.dp)
                    .padding(4.dp)
            ){
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(16.dp), // Padding around the grid
                    verticalArrangement = Arrangement.spacedBy(16.dp), // Vertical spacing between items
                    horizontalArrangement = Arrangement.spacedBy(16.dp), // Horizontal spacing between items
                    userScrollEnabled = false,
                    modifier = Modifier

                ) {
                    items(icons.size) { index ->
                        CircularButton(
                            icon = {
                                Icon(
                                    imageVector = icons[index],
                                    contentDescription = iconDescriptions[index],
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .wrapContentSize()
                                )
                            },
                            text = iconDescriptions[index],
                            onClick = navigationActions[index]
                        )
                    }
                }
            }


            //Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Trending around you --->",
                modifier = Modifier
                    .padding(start = 24.dp),
                //fontSize = 16.sp,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.W900,

            )

            Box(modifier = Modifier.fillMaxWidth()){
                LazyRow (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(SampleItems.size) { item ->
                        SaleItemCard(item = SampleItems[item],onClickToDetailScreen = onClickToDetailScreen)
                    }

//                    items(SampleItems.size) { index ->
//                        //HomeScreenItemCard(index = codes[index])
//                        HomeScreenItemCard(painter = painter, contentDescription = "", title = codes[index])
//                        SaleItemCard(item = )
//                    }
                }
            }

            Text(
                text = "Recently Viewed  --->",
                modifier = Modifier
                    .padding(start = 24.dp),
                //fontSize = 16.sp,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.W900
            )

            Box(modifier = Modifier.fillMaxWidth()){
                LazyRow (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(
                        SampleItems.size,
                        key = {
                            SampleItems[it].id
                        }
                    ) { item ->
                        SaleItemCard(item = SampleItems[item],onClickToDetailScreen = onClickToDetailScreen)
                    }
                }
            }


        }

    }
}
@Preview
@Composable
fun HomescreenPreview(){
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
    HomeScreen({},{},{},{},{},{},{},{},{}, sampleItems)
}