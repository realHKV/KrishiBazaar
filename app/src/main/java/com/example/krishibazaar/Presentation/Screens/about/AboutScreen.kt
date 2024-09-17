package com.example.krishibazaar.Presentation.Screens.about

//import androidx.benchmark.perfetto.Row
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.krishibazaar.Data.User.User
import com.example.krishibazaar.Data.User.UserViewModel
import com.example.krishibazaar.Navigation.HomeScreenRoute
import com.example.krishibazaar.Navigation.SignInRoute
import com.example.krishibazaar.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    onClickToHomeScreen: () -> Unit,
    userViewModel: UserViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController
){
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

    ) { innerpadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            // Dummy Profile Image
//            Spacer(modifier = Modifier.height(24.dp))
//            Image(
//                painter = painterResource(id = R.drawable.farmer), // Dummy circular image
//                contentDescription = "Profile Picture",
//
//                modifier = Modifier
//                    .size(120.dp)
//                    .border(
//                        width = 1.dp,
//                        color = Color.Black,
//                        shape = CircleShape
//                    )
//                    .clip(CircleShape), // Make the image circular
//                contentScale = ContentScale.Crop
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Name
//            // Name Row
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
//                    .padding(16.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Person,
//                    contentDescription = "Name Icon",
//                    tint = Color.Black
//                )
//                Spacer(modifier = Modifier.width(16.dp))
//                // Name
//                Text(
//                    text = "Ram Dalal",
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(16.dp),
//                    fontSize = 24.sp
//                )
//            }
//
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Email Row
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
//                    .padding(16.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Email,
//                    contentDescription = "Email Icon",
//                    tint = Color.Black
//                )
//                Spacer(modifier = Modifier.width(16.dp))
//
//                // Email
//                Text(
//                    text = Firebase.auth.currentUser?.email.toString(),
//                    fontSize = 16.sp,
//                    modifier = Modifier.padding(16.dp),
//                    color = Color.Black
//                )
//            }
//
//
//            Spacer(modifier = Modifier.height(4.dp))
//
//            // Phone Row
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
//                    .padding(16.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Phone,
//                    contentDescription = "Phone Icon",
//                    tint = Color.Black
//                )
//                Spacer(modifier = Modifier.width(16.dp))
//
//                // Phone
//                Text(
//                    text = "+98 8595039795",
//                    fontSize = 16.sp,
//                    color = Color.Black
//                )
//            }
//
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//
//            //descript row
//            Row(
//                verticalAlignment = Alignment.Top,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
//                    .padding(16.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Info,
//                    contentDescription = "About Icon",
//                    tint = Color.Black
//                )
//                Spacer(modifier = Modifier.width(16.dp))
//
//                // Additional content (optional)
//                Text(
//                    text = "I am Ram Dalal, an Indian farmer dedicated to using innovative techniques " +
//                            "and sustainable practices to improve agriculture and support my community.",
//                    fontSize = 14.sp,
//                    color = Color.Black,
//                    modifier = Modifier.padding(16.dp)
//                )
//            }
//
//            Button(onClick = {FirebaseAuth.getInstance().signOut()}) {
//                Text(text = "Sign Out")
//            }
            val isUserChecked = remember { mutableStateOf(false) }
            val defaultUser = Firebase.auth.currentUser?.let {
                User(
                    UserId = it.uid, // will be replaced with the actual UID
                    name = "Default Name",
                    photoUrl = "https://firebasestorage.googleapis.com/v0/b/krishibazzaar.appspot." +
                            "com/o/doge%20sile.jpeg?alt=media&token=6aed05f4-4ab4-44f9-a1e5-6c59876990cc",
                    email = it.email.toString(),
                    phoneNumber = "0000000000"
                )
            }

            LaunchedEffect(Unit) {
                if (defaultUser != null) {
                    userViewModel.checkUserAndUploadIfNeeded(defaultUser) { userExists ->
                        isUserChecked.value = true
                    }
                }
            }

            if (!isUserChecked.value) {
                // Show loading while checking
                Text(text = "Checking user...")
            } else {
                // Show the rest of the UI or the user profile
                Text(text = "User check complete.")
                val userData1 by userViewModel.userData.collectAsState()

                // Fetch user data from Firestore when this composable is first launched
                LaunchedEffect(Unit) {
                    userViewModel.getUserFromFirestore()
                }

                var name by remember { mutableStateOf(userData1?.name ?: "") }
                var phoneNumber by remember { mutableStateOf(userData1?.phoneNumber ?: "") }
                var isEditMode by remember { mutableStateOf(false) }
                var isUpdating by remember { mutableStateOf(false) }
                var updateMessage by remember { mutableStateOf("") }

                userData1?.let {
                    Column {
                        if (!isEditMode) {
                            // Display user data (view mode)
                            // Dummy Profile Image
                            Spacer(modifier = Modifier.height(24.dp))

                            if (it.photoUrl.isNotEmpty()) {
                                Box(
                                    contentAlignment = Alignment.Center, // Center the progress indicator inside the Box
                                    modifier = Modifier.size(120.dp) // Keep the Box size the same as the image
                                ) {
                                    // Create an ImageRequest for loading the image
                                    val imageRequest = ImageRequest.Builder(LocalContext.current)
                                        .data(it.photoUrl)
                                        .crossfade(true)
                                        .build()

                                    // Remember and monitor the state of the image painter
                                    val painter = rememberAsyncImagePainter(imageRequest)
                                    val painterState = painter.state

                                    // Display the AsyncImage
                                    AsyncImage(
                                        model = imageRequest,
                                        contentDescription = "Profile Picture",
                                        modifier = Modifier
                                            .size(120.dp) // Set the size of the image
                                            .border(
                                                width = 1.dp,
                                                color = Color.Black,
                                                shape = CircleShape // Circular border
                                            )
                                            .clip(CircleShape), // Clip the image to a circular shape
                                        contentScale = ContentScale.Crop // Crop the image to fill the bounds
                                    )

                                    // Show a CircularProgressIndicator only while the image is loading
                                    when (painterState) {
                                        is AsyncImagePainter.State.Loading -> {
                                            // Show progress bar when loading
                                            CircularProgressIndicator(
                                                modifier = Modifier.align(Alignment.Center) // Center the progress bar inside the Box
                                            )
                                        }
                                        is AsyncImagePainter.State.Success -> {
                                            // Do nothing - Image is loaded, progress bar will not show
                                        }
                                        is AsyncImagePainter.State.Error -> {
                                            // Handle the error state if the image fails to load
                                            Text(
                                                text = "Image failed to load",
                                                color = Color.Red,
                                                modifier = Modifier.align(Alignment.Center) // Center the error message
                                            )
                                        }

                                        AsyncImagePainter.State.Empty -> TODO()
                                    }
                                }


                            } else {
                                Image(
                                    painter = painterResource(id = R.drawable.farmer),
                                    contentDescription = "Profile Picture",
                                    modifier = Modifier
                                        .size(120.dp)
                                        .border(
                                            width = 1.dp,
                                            color = Color.Black,
                                            shape = CircleShape
                                        )
                                        .clip(CircleShape), // Make the image circular
                                    contentScale = ContentScale.Crop // Crop the drawable image
                                )
                            }


                            Text(text = "Name: ${it.name}")
                            Text(text = "Email: ${it.email}")
                            Text(text = "Phone: ${it.phoneNumber}")
                            Spacer(modifier = Modifier.height(16.dp))

                            // Edit button to enable edit mode
                            Button(onClick = {
                                isEditMode = true
                                name = it.name
                                phoneNumber = it.phoneNumber
                            }) {
                                Text(text = "Edit Profile")
                            }
                            val scope=rememberCoroutineScope()
                            Button(onClick = {
                                Log.d("hkv2","scope")
                                try {
                                    FirebaseAuth.getInstance().signOut()
                                    Log.d("hkv2","sign out complete")
                                    navController.navigate(SignInRoute)
                                    Log.d("hkv2","sign in page")
                                }catch (e:Exception){
                                    Log.e("hkv2", "Error during navigation: ${e.message}")
                                }
//                                scope.launch {
//                                    Log.d("hkv2","scope launched")
//                                    FirebaseAuth.getInstance().signOut()
//                                    Log.d("hkv2","sign out complete")
//                                    navController.popBackStack()
//                                    Log.d("hkv2","popedbackstack")
//                                    navController.navigate(SignInRoute)
//                                    Log.d("hkv2","sign in page")
//
//                                    // Other cleanup or navigation logic
//                                }
                            }
                            ) {
                                Text(text = "Sign Out")
                            }
                        } else {
                            // Edit mode with input fields
                            TextField(
                                value = name,
                                onValueChange = { name = it },
                                label = { Text("Name") }
                            )

                            TextField(
                                value = phoneNumber,
                                onValueChange = { phoneNumber = it },
                                label = { Text("Phone Number") }
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // Save button
                            Button(onClick = {
                                isUpdating = true
                                userViewModel.updateUserInFirestore(
                                    newName = name,
                                    newPhoneNumber = phoneNumber,
                                    onSuccess = {
                                        isUpdating = false
                                        updateMessage = "Profile updated successfully!"
                                        isEditMode = false // Exit edit mode
                                    },
                                    onError = { e ->
                                        isUpdating = false
                                        updateMessage = "Failed to update profile: ${e.message}"
                                    }
                                )
                            }) {
                                Text(text = "Save Changes")
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            // Cancel button
                            Button(onClick = {
                                isEditMode = false
                                updateMessage = ""
                            }) {
                                Text(text = "Cancel")
                            }
                        }

                        // Display loading or message
                        if (isUpdating) {
                            Text(text = "Updating...")
                        } else if (updateMessage.isNotEmpty()) {
                            Text(text = updateMessage)
                        }
                    }
                } ?: run {
                    Text(text = "Loading user data...")
                }
//                // Display user data if available
//                userData1?.let { user ->
//                    Column {
//                        Text(text = "Name: ${user.name}")
//                        Text(text = "Email: ${user.email}")
//                        Text(text = "Phone: ${user.phoneNumber}")
//                        // You can also display the profile picture, etc.
//                    }
//                } ?: run {
//                    // Show loading or error state if user data is not available
//                    Text(text = "Loading user data...")
//                }
            }

        }

    }
}

@Preview
@Composable
fun AboutScreenPreview(){
    AboutScreen({},navController = NavController(context = LocalContext.current))

}