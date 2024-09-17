package com.example.krishibazaar.Presentation.uploadingProducts

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.EmptyBuildDrawCacheParams.density
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.krishibazaar.Data.Item.onlineItemData
import com.example.krishibazaar.Data.ItemCategories
import com.example.krishibazaar.Navigation.SellScreenRoute
import com.example.krishibazaar.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadItemForSaleScreen(
    navController: NavController,
    productViewModel: ProductViewModel = viewModel(),
    //onProductAdded: () -> Unit
){

    var name by remember { mutableStateOf("") }
    val soldBy = Firebase.auth.currentUser?.uid ?: "error" // Assign user UID directly
    //var stars by remember { mutableIntStateOf(0) }
    var description by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var salePrice by remember { mutableStateOf("") }
    var originalPrice by remember { mutableStateOf("") }
    var rateType by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val isUploading = remember { mutableStateOf(false) } // Track upload progress

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(SellScreenRoute)} ) {
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
//                    IconButton(onClick = { /* Handle search icon click */ }) {
//                        Icon(
//                            imageVector = Icons.Default.Search,
//                            contentDescription = "Search",
//                            tint = colorResource(id = R.color.white)
//                        )
//                    }
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
                .padding(innerpadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            if (isUploading.value) {
                CircularProgressIndicator() // Progress bar
            }
            //name
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Product Name") }
            )

//            //sold by
//            OutlinedTextField(
//                value = soldBy,
//                onValueChange = { soldBy = it },
//                label = { Text("Sold By") }
//            )

//            //stars
//            OutlinedTextField(
//                value = stars.toString(),
//                onValueChange = { stars = it.toIntOrNull() ?: 0 },
//                label = { Text("Stars (0-5)") },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//            )

            //category
            OutlinedTextField(
                value = category,
                onValueChange = { category = it },
                label = { Text("Category") }
            )

            //description
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") }
            )



            //sale price
            OutlinedTextField(
                value = salePrice,
                onValueChange = { salePrice = it },
                label = { Text("Sale Price") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = originalPrice?:"",
                onValueChange = { originalPrice = it },
                label = { Text("Original Price (Optional)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = rateType,
                onValueChange = { rateType = it },
                label = { Text("Rate Type (e.g., per unit, per kg)") }
            )

            Button(onClick = { imagePickerLauncher.launch("image/*") }) {
                Text(text = "Pick Image")
            }

            imageUri?.let {
                Text(text = "Image selected!")
            }
            //Log.d("hkv4","reached upload screen")

            Button(onClick = {
                // Validate inputs before proceeding
                val salePriceDouble = salePrice.toDoubleOrNull()
                val originalPriceDouble = originalPrice.toDoubleOrNull()

                if (name.isEmpty() || description.isEmpty() || category.isEmpty() || rateType.isEmpty()) {
                    Log.e("hkv4","Please fill in all required fields.")
                } else if (salePriceDouble == null) {
                    Log.e("hkv4","Invalid sale price format.")
                } else {
                    Log.d("hkv4","null")
                    //errorMessage = null // Clear previous errors

                    val tempOnlineItemData = onlineItemData(
                        id = UUID.randomUUID().toString(),
                        name = name,
                        soldBy = soldBy,
                        description = description,
                        category = category,
                        salePrice = salePriceDouble,
                        originalPrice = originalPriceDouble,
                        rateType = rateType,
                        imageUrl = "" // Placeholder for now
                    )

                    if (imageUri != null) {
                        Log.d("hkv4","initiated uploadProduct")
                        isUploading.value = true
                        productViewModel.uploadProduct(
                            product = tempOnlineItemData,
                            imageUri = imageUri!!,
                            onProductAdded = {
                                isUploading.value=false
                                Log.d("hkv4", "Product added successfully.")
                            }
                        )
                    } else {
                        Log.e("hkv4","Please select an image.")
                        //errorMessage = "Please select an image."
                    }
                }
            }, modifier = Modifier.padding(top = 16.dp)) {
                Text(text = "Add Product")
            }
            //Log.d("hkv4","after button")


            if (productViewModel.uploadState.value) {
                Text("Product successfully uploaded!")
            }
        }
    }
}

@Preview
@Composable
fun UploadItemForSaleScreenPreview(){
    UploadItemForSaleScreen(
        navController = NavController(LocalContext.current),
        productViewModel = ProductViewModel(),
    )

}