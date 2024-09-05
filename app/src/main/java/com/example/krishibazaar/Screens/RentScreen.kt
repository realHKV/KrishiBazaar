package com.example.krishibazaar.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.krishibazaar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RentScreen(
    onClickToHomeScreen: () -> Unit
) {
    Scaffold(
        topBar =  {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClickToHomeScreen) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = colorResource(id = R.color.white)
                        )
                    }
                },
//             title =  {Text(stringResource(R.string.About_Screen))} ,
                title = { Text(text = "Krishi Bazaar") },
                actions = {
                    IconButton(onClick = { /* Handle search icon click */ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = colorResource(id = R.color.white)
                        )
                    }
                    IconButton(onClick = { /* Handle login icon click */ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Login",
                            tint = colorResource(id = R.color.white)//MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700),
                    titleContentColor = colorResource(id = R.color.white)
//                    containerColor = MaterialTheme.colorScheme.secondary,
//                    titleContentColor = MaterialTheme.colorScheme.inversePrimary,
                )
            )
        },
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                //contentAlignment = Alignment.BottomCenter // Align FAB at the bottom center of the Box
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp)
                ) {
                    FloatingActionButton(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)  // Each FAB takes up an equal amount of space
                            .padding(8.dp)
                            .height(64.dp)

                    ) {
                        Row {
                            Icon(Icons.Default.Call, contentDescription = "Contact Seller")
                            Text(text = "Contact Seller", style = MaterialTheme.typography.titleMedium)
                        }

                    }
                    FloatingActionButton(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)  // Each FAB takes up an equal amount of space
                            .padding(8.dp)
                            .height(64.dp)

                    ) {
                        Row {
                            Icon(Icons.Default.Check, contentDescription = "Buy Now")
                            Text(text = "Rent Now", style = MaterialTheme.typography.titleMedium)
                        }

                    }
                }

            }

        }
    ){innerpadding->
//        id = 10,
//        name = "Tractor",
//        soldBy = "Rajendra Mechanic",
//        stars = 4,
//        description = "A reliable tractor, perfect for plowing and other farm activities. Well-maintained and ready to serve your agricultural needs.",
//        painter = painterResource(id = R.drawable.tractor),
//        originalPrice = 150.0,
//        salePrice = 130.0
        val scrollState1 = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(innerpadding)
                .verticalScroll(scrollState1)
            ,

            ) {
            //Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.tractor),
                contentDescription = "Tractor",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(8.dp)
            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 1.dp)
            )
            Text(
                text = "Mahindra Tractor",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(top = 16.dp, start = 8.dp)
            )
//            Divider(
//                color = Color.Gray,
//                thickness = 1.dp,
//                modifier = Modifier.padding(vertical = 1.dp)
//            )

            val filledStarPainter = painterResource(id = R.drawable.cool_star)
            Text(
                text = "Sold By : Rajendra Mechanic",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 8.dp, start = 8.dp, bottom = 8.dp)
            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 1.dp)
            )
            RatingBar(
                currentRating = 5,
                filledStar = filledStarPainter
            )

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 1.dp)
            )
            Row {
                Text(
                    text = "Rent for 1 day : \u20B9 500 / day",
                    style = MaterialTheme
                        .typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
//                Text(
//                    text = item.originalPrice.toString(),
//                    style = MaterialTheme.typography.titleLarge,
//                    textDecoration = TextDecoration.LineThrough,
//                    modifier = Modifier.padding(8.dp)
//                )

            }

            Text(
                text = "A reliable tractor, perfect for plowing and other farm activities." +
                        " Well-maintained and ready to serve your agricultural needs",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.padding(bottom = 150.dp))
        }
    }
}

@Preview
@Composable
fun RentScreenPreview(){
    RentScreen({})
}