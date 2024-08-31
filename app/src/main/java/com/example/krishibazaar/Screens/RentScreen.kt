package com.example.krishibazaar.Screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RentScreen(

) {
    Scaffold(
        topBar =  {
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
                    IconButton(onClick = { /* Handle search icon click */ }) {
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
            )
        }

    ){innerpadding->
        LazyColumn(
            contentPadding = innerpadding
        ) {

        }
    }
}