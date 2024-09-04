package com.example.krishibazaar.location

import android.Manifest
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.krishibazaar.MainActivity
import com.example.krishibazaar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(
    onClickToHomeScreen: () -> Unit
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
        val locationViewModel = LocationViewModel()
        val context = LocalContext.current
        val locationUtils = LocationUtils(context)
        LocationDisplay(locationUtils = locationUtils, viewModel = locationViewModel, context = context, innerPadding = innerpadding)




    }
}

@Composable
fun LocationDisplay(
    innerPadding: PaddingValues,
    locationUtils: LocationUtils,
    viewModel: LocationViewModel,
    context: Context
){
    val location=viewModel.location.value

    val address = location?.let {
        locationUtils.reverseGeoCodeLocation(location)
    }

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions() ,
        onResult ={permissions ->
            if (permissions[Manifest.permission.ACCESS_COARSE_LOCATION]==true
                &&
                permissions[Manifest.permission.ACCESS_FINE_LOCATION]==true
            ){
                //we have permission
                locationUtils.requestLocationUpdates(viewModel)
            }
            else{
                //ask for permission
                val rationaleRequired = ActivityCompat.shouldShowRequestPermissionRationale( //boolean
                    context as MainActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) ||
                        ActivityCompat.shouldShowRequestPermissionRationale(
                            context as MainActivity,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                        )
                if(rationaleRequired){
                    Toast.makeText(
                        context,
                        "Location is required for this feature",
                        Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(
                        context,
                        "Location is required for this feature, please enable it in android settings",
                        Toast.LENGTH_SHORT).show()
                }
            }


        }
    )


    Column(modifier = Modifier.padding(innerPadding)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        if(location!=null){
            Text(text = "Address: ${location.latitude} , ${location.longitude}")
            Text(text = "$address")
        }else{
            Text(text = "Location not Available")
        }

        if(location==null) {
            Button(onClick = {
                if (locationUtils.hasLocationPermissions(context)) {
                    //update the location if we already have permission
                    locationUtils.requestLocationUpdates(viewModel)
                } else {
                    //request location permission
                    requestPermissionLauncher.launch(
                        arrayOf(
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                        )
                    )
                }
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_700) // Customize the button color here
                )
            ) {
                Text(text = "Get Location")

            }
        }


    }
}

@Preview
@Composable
fun LocationScreenPreview(){
    LocationScreen({})

}