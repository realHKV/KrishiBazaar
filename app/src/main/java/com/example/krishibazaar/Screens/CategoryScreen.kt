package com.example.krishibazaar.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krishibazaar.R

@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CategoryScreen(
//    onClickToHomeScreen: () -> Unit
//) {
//    val scrollState = rememberScrollState()
//    // Example data for buttons with icons and labels
//    val icons = listOf(
//        ButtonItem(R.drawable.crop, "Crops"),
//        ButtonItem(R.drawable.vegetable, "Vegetables"),
//        ButtonItem(R.drawable.fruit, "Fruits"),
//        ButtonItem(R.drawable.fertilizer, "Fertilizer") ,
//        ButtonItem(R.drawable.cow, "Animals"),
//        ButtonItem(R.drawable.spice, "Spices"),
//        ButtonItem(R.drawable.seed, "Seeds"),
//        ButtonItem(R.drawable.grass, "Grass"),
//        ButtonItem(R.drawable.tractor_icon, "Vehicle")
//    )
//
//    // Add more items if needed
//    val bottomIcons = listOf(
//        ButtonItem(R.drawable.pesticide, " Pesticides"),
//        ButtonItem(R.drawable.tool, "Tools"),
//        ButtonItem(R.drawable.sell, " Trading"),
//        ButtonItem(R.drawable.machin, "Machinery")
//    )
////hello
//
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                navigationIcon = {
//                    IconButton(onClick = onClickToHomeScreen) {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "Localized description",
//                            tint = MaterialTheme.colorScheme.onPrimary
//                        )
//                    }
//                },
//                title = { Text(text = "Krishi Bazaar") },
//                actions = {
//                    IconButton(onClick = { /* Handle search icon click */ }) {
//                        Icon(
//                            imageVector = Icons.Default.Search,
//                            contentDescription = "Search",
//                            tint = MaterialTheme.colorScheme.onPrimary
//                        )
//                    }
//                    IconButton(onClick = { /* Handle account icon click */ }) {
//                        Icon(
//                            imageVector = Icons.Default.AccountCircle,
//                            contentDescription = "Account",
//                            tint = MaterialTheme.colorScheme.onPrimary
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                    //containerColor = MaterialTheme.colorScheme.secondary,
////                    titleContentColor = MaterialTheme.colorScheme.inversePrimary,
//                    containerColor = colorResource(id = R.color.teal_700),
//                    titleContentColor = colorResource(id = R.color.white)
//                )
//            )
//        },
//
//        modifier = Modifier.fillMaxSize()
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White)
//                .verticalScroll(scrollState)
//                .padding(innerPadding),
//            horizontalAlignment = Alignment.CenterHorizontally
//        )
//        {
//            Text(
//                text = "All Categories",
//
//                modifier = Modifier
//                    .padding(16.dp),
//                style = MaterialTheme.typography.titleLarge.copy(
//                    fontWeight = FontWeight.W900
//                )
//            )
//
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(3),
//                userScrollEnabled = false,
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth(), // Ensure the grid takes up the available space
//                horizontalArrangement = Arrangement.spacedBy(16.dp),
//                verticalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                itemsIndexed(icons) { index, buttonItem ->
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center,
//                        modifier = Modifier.padding(4.dp)
//                    ) {
//                        Button(
//                            onClick = { /* Handle button click */ },
//                            modifier = Modifier
//                                .size(80.dp) // Adjust size as needed
//                            ,
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = colorResource(id = R.color.white), // Set the background color here
//                                contentColor = Color.Red // Set the text/icon color here
//                            )
//                        ) {
//                            Icon(
//                                painter = painterResource(id = buttonItem.iconResId),
//                                contentDescription = null,
//                                modifier = Modifier.size(50.dp)
//                            )
//                        }
//                        Spacer(modifier = Modifier.height(4.dp))
//                        Text(
//                            text = buttonItem.label,
//                            style = MaterialTheme.typography.bodySmall,
//                            fontSize = 15.sp
//                        )
//                    }
//                    if ((index + 1) % 3 == 0) {
//                        Spacer(modifier = Modifier.height(16.dp))
//                    }
//                }
//            }
//            Divider(
//                modifier = Modifier.background(Color.Gray)
//                    .fillMaxWidth()
//                    .padding(vertical = 1.dp), // Adjust padding as needed
//                thickness = 1.dp // Set the thickness of the divider
//            )
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(3),
//                userScrollEnabled = false,
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth(), // Ensure the grid takes up the available space
//                horizontalArrangement = Arrangement.spacedBy(16.dp),
//                verticalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                itemsIndexed(bottomIcons) { index, buttonItem ->
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center,
//                        modifier = Modifier.padding(4.dp)
//                    ) {
//                        Button(
//                            onClick = { /* Handle button click */ },
//                            modifier = Modifier
//                                .size(90.dp), // Adjust size as needed
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = colorResource(id = R.color.white), // Set the background color here
//                                contentColor = Color.Red // Set the text/icon color here
//                            )
//                            ) {
//                            Icon(
//                                painter = painterResource(id = buttonItem.iconResId),
//                                contentDescription = null,
//                                modifier = Modifier.size(80.dp)
//                            )
//                        }
//                        Spacer(modifier = Modifier.height(4.dp))
//                        Text(
//                            text = buttonItem.label,
//                            style = MaterialTheme.typography.bodySmall,
//                            fontSize = 15.sp
//                        )
//                    }
//                    if ((index + 1) % 3 == 0) {
//                        Spacer(modifier = Modifier.height(16.dp))
//                    }
//                }
//            }
//        }
//    }
//}
@Composable
fun CategoryScreen(
    onClickToHomeScreen: () -> Unit
) {
    val scrollState = rememberScrollState()
    // Example data for buttons with icons and labels
    val icons = listOf(
        ButtonItem(R.drawable.crop, "Crops"),
        ButtonItem(R.drawable.vegetable, "Vegetables"),
        ButtonItem(R.drawable.fruit, "Fruits"),
        ButtonItem(R.drawable.fertilizer, "Fertilizer"),
        ButtonItem(R.drawable.cow, "Animals"),
        ButtonItem(R.drawable.spice, "Spices"),
        ButtonItem(R.drawable.seed, "Seeds"),
        ButtonItem(R.drawable.grass, "Grass"),
        ButtonItem(R.drawable.tractor_icon, "Vehicle")
    )

    val bottomIcons = listOf(
        ButtonItem(R.drawable.pesticide, "Pesticides"),
        ButtonItem(R.drawable.tool, "Tools"),
        ButtonItem(R.drawable.sell, "Trading"),
        ButtonItem(R.drawable.machin, "Machinery")
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClickToHomeScreen) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                title = { Text(text = "Krishi Bazaar") },
                actions = {
                    IconButton(onClick = { /* Handle search icon click */ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                    IconButton(onClick = { /* Handle account icon click */ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Account",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700),
                    titleContentColor = colorResource(id = R.color.white)
                )
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "All Categories",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.W900
                )
            )

            // First grid section
            icons.chunked(3).forEach { rowItems ->
                Row(
                    //modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowItems.forEach { buttonItem ->
                        CategoryButtonItem(buttonItem)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Divider
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                color = Color.Gray,
                thickness = 1.dp
            )

            // Second grid section
            bottomIcons.chunked(3).forEach { rowItems ->
                Row(
                    //modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowItems.forEach { buttonItem ->
                        CategoryButtonItem(buttonItem)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

    }
}
@Composable
fun CategoryButtonItem(buttonItem: ButtonItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(4.dp)
    ) {
        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier.size(80.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.white),
                contentColor = Color.Red
            )
        ) {
            Icon(
                painter = painterResource(id = buttonItem.iconResId),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = buttonItem.label,
            style = MaterialTheme.typography.bodySmall,
            fontSize = 15.sp
        )
    }
}

data class ButtonItem(val iconResId: Int, val label: String)

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    CategoryScreen({})
}