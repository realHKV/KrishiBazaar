package com.example.krishibazaar.Presentation.Screens.SignIn.loginScreen

import android.util.Log
import android.widget.Toast

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.krishibazaar.Navigation.HomeScreenRoute

import com.example.krishibazaar.Navigation.SignInRoute
import com.example.krishibazaar.Navigation.SignUpRoute
import com.example.krishibazaar.Presentation.googleSignIn.GoogleSignInViewModel
import com.example.krishibazaar.R



@Composable
fun SignInScreen(navController: NavController,googleSignInViewModel: GoogleSignInViewModel) {

    val viewModel =SignInViewModel()
    val uiState = viewModel.state.collectAsState()
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current


    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.White)
            )
            OutlinedTextField(value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email") })
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.size(16.dp))

            if (uiState.value == SignInState.Loading) {
                CircularProgressIndicator()
            } else {
                Button(
                    onClick =  {viewModel.signIn(email, password)},
                    modifier = Modifier.fillMaxWidth(),
                    enabled = email.isNotEmpty() && password.isNotEmpty() && (uiState.value == SignInState.Nothing || uiState.value == SignInState.Error)
                ) {
                    Text(text = "Sign In")
                    LaunchedEffect(key1 = uiState.value) {

                        when (uiState.value) {
                            is SignInState.Success -> {
                                Log.d("HKV1","success")
                                navController.navigate(route = HomeScreenRoute){
                                    popUpTo(SignInRoute) { inclusive = true }
                                }
                            }

                            is SignInState.Error -> {
                                Toast.makeText(context, "Sign In failed", Toast.LENGTH_SHORT).show()
                            }

                            else -> {}
                        }
                    }
                }

                TextButton(onClick = { navController.navigate(SignUpRoute) }) {
                    Text(text = "Don't have an account? Sign Up")
                }


            }
            OutlinedButton(
                onClick = { googleSignInViewModel.handleGoogleSignIn(context,navController) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White
                )

            ) {
                Image(
                    painter = painterResource(R.drawable.ic_google),
                    contentDescription = "Google sign in"
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignInScreen() {
    SignInScreen(navController = rememberNavController(), googleSignInViewModel = GoogleSignInViewModel())
}