package com.example.krishibazaar.Screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krishibazaar.Data.itemData
import com.example.krishibazaar.R
//import com.example.krishibazaar.uiElements.HomeScreenItemCard
//import com.example.krishibazaar.uiElements.HomeScreenItemCard
//import com.example.krishibazaar.uiElements.ItemCard


@Composable
fun CircularButton(icon: @Composable () -> Unit, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Button(
            onClick = { /* Handle button click */ },
            shape = CircleShape,
            elevation =  ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 30.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            ) ,
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray, // Set the background color here
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
        Text(
            text = "idk",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClickToSearchScreen: () -> Unit,
    SampleItems: List<itemData>
) {
    val icons = listOf(
        Icons.Default.Favorite,
        Icons.Default.Star,
        Icons.Default.Home,
        Icons.Default.Search,
        Icons.Default.Settings,
        Icons.Default.AccountCircle
    )

    val iconDescriptions = listOf(
        "Favourite", "Star", "Home", "Search", "Settings", "Account"
    )
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
         CenterAlignedTopAppBar(
             navigationIcon = {
                 IconButton(onClick = { /*TODO*/ }) {
                     Icon(
                         imageVector = Icons.AutoMirrored.Filled.List,
                         contentDescription = "Localized description",
                         tint = MaterialTheme.colorScheme.inversePrimary
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
                         tint = MaterialTheme.colorScheme.inversePrimary
                     )
                 }
                 IconButton(onClick = { /* Handle login icon click */ }) {
                     Icon(
                         imageVector = Icons.Default.AccountCircle,
                         contentDescription = "Login",
                         tint = MaterialTheme.colorScheme.inversePrimary
                     )
                 }
             },
             colors = TopAppBarDefaults.topAppBarColors(
                 containerColor = MaterialTheme.colorScheme.secondary,
                 titleContentColor = MaterialTheme.colorScheme.inversePrimary,
             )
         ) },
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter // Align FAB at the bottom center of the Box
            ){
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(70.dp)
                        .offset(y = (50).dp) // Adjust the offset to position the FAB above the bottom bar

                        //.align(Alignment.CenterHorizontally) // Center the FAB horizontally
                        .shadow(elevation = 10.dp, shape = CircleShape)
                    ,
                ) {
                    Icon(

                        imageVector = Icons.Default.Add,
                        contentDescription = "Localized description",
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            }

        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                ,
                containerColor = MaterialTheme.colorScheme.secondary,
            ) {

            }
        },
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
            Box(
                modifier = Modifier
                    //.wrapContentHeight()
                    .height(290.dp)
                    .padding(4.dp)
            ){
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(16.dp), // Padding around the grid
                    verticalArrangement = Arrangement.spacedBy(16.dp), // Vertical spacing between items
                    horizontalArrangement = Arrangement.spacedBy(16.dp), // Horizontal spacing between items
                    userScrollEnabled = false,
                    modifier = Modifier
                    //.padding(innerPadding)
                    //.fillMaxSize()
                    //.padding(16.dp)
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
                            text = iconDescriptions[index]
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Hot Dog Market frfr --->",
                modifier = Modifier
                    .padding(start = 32.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,

            )
            Spacer(modifier = Modifier.height(16.dp))

            val painter= painterResource(id = R.drawable.doge)
            val codes  = listOf("1","2","3","4","5")
            Box(modifier = Modifier.fillMaxWidth()){
                LazyRow (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(SampleItems.size) { item ->
                        SaleItemCard(item = SampleItems[item])
                    }

//                    items(SampleItems.size) { index ->
//                        //HomeScreenItemCard(index = codes[index])
//                        HomeScreenItemCard(painter = painter, contentDescription = "", title = codes[index])
//                        SaleItemCard(item = )
//                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Hot Dog Market 2 frfr --->",
                modifier = Modifier
                    .padding(start = 32.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,

                )
            Spacer(modifier = Modifier.height(16.dp))

            Box(modifier = Modifier.fillMaxWidth()){
                LazyRow (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(SampleItems.size) { item ->
                        SaleItemCard(item = SampleItems[item])
                    }
                }
            }


        }

    }
}
@Preview
@Composable
fun HomescreenPreview(){
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
    HomeScreen({}, sampleItems)
}