package com.example.krishibazaar.Presentation.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.krishibazaar.Data.itemData
import com.example.krishibazaar.R

@Composable
fun CustomRatingStar(
    painter: Painter
    //tint: Color
) {
    Icon(
        painter = painter,
        contentDescription = null,
        //tint = tint,
        modifier = Modifier.size(24.dp)
    )
}

@Composable
fun RatingBar(
    maxRating: Int = 5,
    currentRating: Int,
    filledStar: Painter, // Pass your custom star icon here
    //emptyStar: Painter // Pass an outlined star icon here
    //onRatingChanged: (Int) -> Unit,
    //starsColor: Color = Color.Yellow
    startPadding:Int = 4,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    show:Boolean=true
) {
    Row (
        modifier = Modifier.padding(startPadding.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        if(show){
            for (i in 1..currentRating) {
                Image(
                    painter = filledStar,
                    contentDescription = "",
                    modifier = Modifier
//                    .fillMaxWidth()
                        .size(width = 40.dp, height = 40.dp)
                        .padding(8.dp)
                )
//            CustomRatingStar(
//                painter = filledStar
//            )
            }
            Text(text = "$currentRating/5 Stars", style = style)
        }
        else{
            Text(text = "$currentRating/5 Stars", style = style)
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(item: itemData,onClickToSearchScreen: () -> Unit){
    Scaffold(
        topBar =  {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClickToSearchScreen ) {
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
        },
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                //contentAlignment = Alignment.BottomCenter // Align FAB at the bottom center of the Box
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp)
                ){
                    FloatingActionButton(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)  // Each FAB takes up an equal amount of space
                            .padding(8.dp)
                            .height(64.dp)

                    ) {
                        Row {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Add to Cart")
                            Text(text = "Add to Cart", style = MaterialTheme.typography.titleMedium)
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
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Buy Now")
                            Text(text = "Buy Now", style = MaterialTheme.typography.titleMedium)
                        }

                    }
                }

            }

        }

    ) {innerpadding->
        val scrollState1 = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(innerpadding)
                .verticalScroll(scrollState1)
            ,

        ) {
            //Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = item.painter,
                contentDescription = item.name,
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
                text = item.name,
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
                text = "Sold By : ${item.soldBy}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 8.dp, start = 8.dp, bottom = 8.dp)
            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 1.dp)
            )
            RatingBar(
                currentRating = item.stars,
                filledStar = filledStarPainter
            )

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 1.dp)
            )
            Row {
                Text(
                    text = "\u20B9 ${item.salePrice} / kg",
                    style = MaterialTheme
                        .typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = item.originalPrice.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    textDecoration = TextDecoration.LineThrough,
                    modifier = Modifier.padding(8.dp)
                )

            }

            Text(
                text = item.description ,
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
fun DetailScreenPreview(){
    val painter1: Painter = painterResource(id = R.drawable.doge)
    val sampleItem = itemData(
        id = 1,
        name = "Aloo (Potato)",
        soldBy = "Shankar Singh Gaonwala",
        stars = 5,
        description = "Fresh, organic potatoes from my farm. Perfect for curries, fries, or a hearty aloo paratha. Grown with love and minimal use of chemicals.",
        painter = painter1,
        originalPrice = 1000.0,
        salePrice = 850.0
    )
    DetailScreen(sampleItem,{})

}