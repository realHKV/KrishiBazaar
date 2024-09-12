package com.example.krishibazaar.Presentation.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.krishibazaar.R

data class CartItem(
    val name: String,
    val price: Double,
    val image: Int,
    var quantity: Int
)

@Composable
fun CartItemRow(
    item: CartItem,
    onIncreaseQuantity: () -> Unit,
    onDecreaseQuantity: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Image
        Image(
            painter = painterResource(item.image),
            contentDescription = item.name,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop
        )

        // Item Info
        Column {
            Text(text = item.name, fontWeight = FontWeight.Bold)
            Text(text = "Price: ₹ ${item.price}")
        }

        // Quantity Controls
        Row {
            Button(
                modifier = Modifier.wrapContentSize().size(50.dp),
                onClick = onDecreaseQuantity,

                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_200)
                )
            ) {
                Text("-",color=Color.Black)
            }
            Text(text = item.quantity.toString(), modifier = Modifier.padding(8.dp))
            Button(
                modifier = Modifier.wrapContentSize().size(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_200)
                ),
                onClick = onIncreaseQuantity
            ) {
                Text("+",color=Color.Black)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
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
        }

    ){innerpadding->
        val cartItems = remember {
            mutableStateListOf(
                CartItem("Gheeya", 15.0, R.drawable.wa_gheeya, 1),
                CartItem("Bhindi", 32.0, R.drawable.wa_bhindi, 2)
            )
        }

        var totalAmount by remember { mutableStateOf(0.0) }
        totalAmount = cartItems.sumOf { it.price * it.quantity }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Your Cart",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            // Display cart items
            cartItems.forEachIndexed { index, item ->
                CartItemRow(
                    item = item,
                    onIncreaseQuantity = {
                        cartItems[index] = item.copy(quantity = item.quantity + 1)
                    },
                    onDecreaseQuantity = {
                        if (item.quantity > 1) {
                            cartItems[index] = item.copy(quantity = item.quantity - 1)
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Total Amount
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Total: $$totalAmount",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            // Buy Button
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Handle buy action */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_700)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Buy Items", color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun CartScreenPreview(){
    CartScreen({})
}