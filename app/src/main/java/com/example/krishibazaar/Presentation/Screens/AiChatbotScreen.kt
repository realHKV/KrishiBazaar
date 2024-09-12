package com.example.krishibazaar.Presentation.Screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Colors
import com.example.krishibazaar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatBotScreen(
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
        },
        bottomBar = { ChatInputBar() }

    ){innerpadding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
                .padding(16.dp)

        ) {
            ChatMessage("Hello! How can I assist you today??", isUser = false)
            ChatMessage("Hi, I'm interested in buying fresh vegetables. Do you have tomatoes and spinach available?", isUser = true)
            ChatMessage("Yes, I have both tomatoes and spinach freshly harvested this morning. How many kilos would you like?", isUser = false)
            ChatMessage("I'll take 2 kilos of tomatoes and 1 kilo of spinach. What's the price?", isUser = true)

        }
    }
}

@Composable
fun ChatMessage(message: String, isUser: Boolean) {
    // Alignment for user and bot messages
    val alignment = if (isUser) Alignment.End else Alignment.Start
    val backgroundColor = if (isUser) colorResource(id = R.color.teal_200) else Color.LightGray
    val textColor = Color.Black

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start
    ) {
        Text(
            text = message,
            modifier = Modifier
                .background(backgroundColor)
                .padding(8.dp)
                .widthIn(max = 250.dp), // Limit message width
            color = textColor
        )
    }
}

@Composable
fun ChatInputBar() {
    var text by remember { mutableStateOf("") }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            placeholder = { Text("Type your message ...") }
        )
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.teal_200)),
            onClick = { text=""
            // Handle send message logic
            // You can add message to chat history, for example.
        }) {
            Text("Send",color=Color.Black )
        }
    }
}

@Preview
@Composable
fun ChatBotScreenPreview(){
    ChatBotScreen({})
}