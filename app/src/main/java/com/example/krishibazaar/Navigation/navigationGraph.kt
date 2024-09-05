package com.example.krishibazaar.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.krishibazaar.Data.itemData
import com.example.krishibazaar.Screens.AboutScreen
import com.example.krishibazaar.Screens.CartScreen
import com.example.krishibazaar.Screens.CategoryScreen
import com.example.krishibazaar.Screens.ChatBotScreen
import com.example.krishibazaar.Screens.DetailScreen
import com.example.krishibazaar.Screens.HomeScreen
import com.example.krishibazaar.Screens.RentScreen
import com.example.krishibazaar.Screens.SearchScreen
import com.example.krishibazaar.Screens.SellScreen
import com.example.krishibazaar.location.LocationScreen

@Composable
fun navigation(SampleItems: List<itemData>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreenRoute) {
        composable<HomeScreenRoute> {
            HomeScreen(
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
                onClickToHomeScreen = {
                    navController.navigate(route = HomeScreenRoute)
                }
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
                onClickToHomeScreen = {
                    navController.navigate(route = HomeScreenRoute)
                }
            )
        }
    }

}