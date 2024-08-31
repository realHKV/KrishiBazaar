package com.example.krishibazaar.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.krishibazaar.Data.itemData
import com.example.krishibazaar.R

@Composable
fun SaleItemCard(item: itemData) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
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
                Text(text = item.name, style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$${item.originalPrice}",
                    style = MaterialTheme.typography.bodySmall,
                    textDecoration = TextDecoration.LineThrough,
                    color = Color.Gray
                )
                Text(
                    text = "$${item.salePrice}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onClickToHomeScreen: () -> Unit,
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
                            tint = MaterialTheme.colorScheme.inversePrimary
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
                            tint = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    titleContentColor = MaterialTheme.colorScheme.inversePrimary,
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
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Home")
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                //contentPadding = innerpadding
            ){
                items(SampleItems.size) { item ->
                    SaleItemCard(item = SampleItems[item])
                }
            }

            //Spacer(modifier = Modifier.height(4.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SaleItemScreenPreview() {
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
    SearchScreen({}, sampleItems)
}