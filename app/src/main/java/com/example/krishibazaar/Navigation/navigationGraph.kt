package com.example.krishibazaar.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.krishibazaar.Data.Item.itemData
import com.example.krishibazaar.Presentation.Screens.about.AboutScreen
import com.example.krishibazaar.Presentation.Screens.CartScreen
import com.example.krishibazaar.Presentation.Screens.CategoryScreen
import com.example.krishibazaar.Presentation.Screens.ChatBotScreen
import com.example.krishibazaar.Presentation.Screens.DetailScreen
import com.example.krishibazaar.Presentation.Screens.HomeScreen
import com.example.krishibazaar.Presentation.Screens.RentScreen
import com.example.krishibazaar.Presentation.Screens.SearchScreen
import com.example.krishibazaar.Presentation.Screens.SellScreen
import com.example.krishibazaar.Presentation.Screens.SignIn.loginScreen.SignInScreen
import com.example.krishibazaar.Presentation.uploadingProducts.UploadItemForSaleScreen
import com.example.krishibazaar.Presentation.Screens.signupScreen.SignUpScreen
import com.example.krishibazaar.Presentation.googleSignIn.GoogleSignInViewModel
import com.example.krishibazaar.Presentation.weather.presentation.WeatherScreen
import com.example.krishibazaar.Presentation.weather.presentation.WeatherViewModel
import com.example.krishibazaar.location.LocationScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun navigation(SampleItems: List<itemData>) {
    val navController = rememberNavController()
    val googleSignInViewModel = GoogleSignInViewModel()
    val context = LocalContext.current

    val currentUser = FirebaseAuth.getInstance().currentUser
    val start = if (currentUser != null) HomeScreenRoute else SignInRoute

    NavHost(navController = navController, startDestination = start) {
        composable<HomeScreenRoute> {
            HomeScreen(
                navController,
                SampleItems = SampleItems,
                onClickToSearchScreen = {
                    navController.navigate(route = SearchScreenRoute)
                },

                onClickToDetailScreen = {
                    navController.navigate(route = DetailScreenRoute(it.id))
                },
                onClickToChatbot = {
                    navController.navigate(route = ChatBotScreenRoute)
                },
                onClickToRent = {
                    navController.navigate(route = RentScreenRoute)
                },
                onClickToCart = {
                    navController.navigate(route = CartScreenRoute)
                },
                onClickToSell = {
                    navController.navigate(route = SellScreenRoute)
                },
                onClickToLocation = {
                    navController.navigate(route = LocationScreenRoute)
                },
                onClickToCategoryScreen = {
                    navController.navigate(route = CategoryScreenRoute)
                },
                onClickToAboutScreen = {
                    navController.navigate(route = AboutScreenRoute)
                }
            )
        }
        composable<SearchScreenRoute> {

            SearchScreen(
                SampleItems = SampleItems,
                onClickToHomeScreen = {
                    navController.navigate(route = HomeScreenRoute)
                },
                onClickToDetailScreen = {
                    navController.navigate(route = DetailScreenRoute(it.id))
                }
            )
        }

        composable<DetailScreenRoute> { it ->
            val args = it.toRoute<DetailScreenRoute>()
            SampleItems.find { it.id == args.id }?.let {
                DetailScreen(it,
                    onClickToSearchScreen = {
                        navController.navigate(route = SearchScreenRoute)
                    }
                )
            }
        }

        composable<RentScreenRoute> {
            RentScreen(
                onClickToHomeScreen = {
                    navController.navigate(route = HomeScreenRoute)
                }
            )
        }

        composable<CartScreenRoute> {
            CartScreen(
                onClickToHomeScreen = {
                    navController.navigate(route = HomeScreenRoute)
                }
            )
        }

        composable<SellScreenRoute> {
            SellScreen(
                navController = navController
            )
        }

        composable<ChatBotScreenRoute> {
            ChatBotScreen(
                onClickToHomeScreen = {
                    navController.navigate(route = HomeScreenRoute)
                }
            )
        }

        composable<LocationScreenRoute> {
            LocationScreen(
                onClickToHomeScreen = {
                    navController.navigate(route = HomeScreenRoute)
                }
            )
        }

        composable<CategoryScreenRoute> {
            CategoryScreen(
                onClickToHomeScreen = {
                    navController.navigate(route = HomeScreenRoute)
                }
            )
        }

        composable<AboutScreenRoute> {
            AboutScreen(
                userViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
                navController = navController,
                onClickToHomeScreen = {
                    navController.navigate(route = HomeScreenRoute)
                }
            )
        }

        composable<SignInRoute> {
            SignInScreen(
                navController = navController,
                googleSignInViewModel
            )
        }
        composable<SignUpRoute> {
            SignUpScreen(
                navController
            )
        }

        composable<UploadItemForSaleScreenRoute> {
            UploadItemForSaleScreen(
                navController,
//                onProductAdded = {
//                    navController.navigate(route = HomeScreenRoute)
//                }
            )
        }

        composable<WeatherScreenRoute> {
            WeatherScreen(
                weatherViewModel = WeatherViewModel() ,
                navController = navController)
        }

    }

}