package com.example.krishibazaar.Screens



import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krishibazaar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SellScreen(
    onClickToHomeScreen: () -> Unit
) {
    Scaffold(
        topBar = {
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
                            tint = colorResource(id = R.color.white)
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

    ) { innerpadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerpadding)
        ) {
            //Spacer(modifier = Modifier.height(30.dp))

            // First box
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {  }
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color(0xFFFFCDD2))
                    .border(2.dp, Color.Black)
                ,
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Post item for Sell", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            //Spacer(modifier = Modifier.height(30.dp))

            // Second box
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clickable {  }
                    .height(120.dp)
                    .background(Color(0xFFC8E6C9))
                    .border(2.dp, Color.Black)
                ,
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Post item for Rent", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            //Spacer(modifier = Modifier.height(24.dp))

            // Third box
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(120.dp)
                    .clickable {  }
                    .background(Color(0xFFBBDEFB))
                    .border(2.dp, Color.Black)
                ,
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Post item for Inquiry", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            //Spacer(modifier = Modifier.height(24.dp))

            // Fourth box
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(120.dp)
                    .clickable {  }
                    .background(Color(0xFFFFF9C4))
                    .border(2.dp, Color.Black)
                ,
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Post item for Exchange",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            //Spacer(modifier = Modifier.height(24.dp))

            // Fifth box
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clickable {  }
                    .height(120.dp)
                    .background(Color(0xFFD1C4E9))
                    .border(2.dp, Color.Black)
                ,
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "FAQs regarding farming?",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            //Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
@Preview
@Composable
fun SellScreenPreview(){
    SellScreen({})
}