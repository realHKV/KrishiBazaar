package com.example.krishibazaar.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.krishibazaar.Data.itemData
import com.example.krishibazaar.Screens.DetailScreen
import com.example.krishibazaar.Screens.HomeScreen
import com.example.krishibazaar.Screens.SearchScreen

@Composable
fun navigation(SampleItems: List<itemData>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreenRoute){
        composable<HomeScreenRoute>{
            HomeScreen(
                SampleItems = SampleItems,
                onClickToSearchScreen = {
                    navController.navigate(route = SearchScreenRoute)
                },

                onClickToDetailScreen = {
                    navController.navigate(route = DetailScreenRoute(it.id))
                }
//                onNavigateToAbout = {
//                    navController.navigate(route = AboutRoute)
//                }
            )
        }
        composable<SearchScreenRoute>{

                SearchScreen(
                    SampleItems = SampleItems,
                    onClickToHomeScreen = {
                        navController.navigate(route = HomeScreenRoute)
                    },
                    onClickToDetailScreen = {
                        navController.navigate(route = DetailScreenRoute(it.id))
                    }
                )
//            val args = it.toRoute<detailroute>()
//            DetailScreen(args.id,
//                onClickToHome = {
//                    navController.navigate(route = HomeRoute)
//                },
//                onNavigateToAbout = {
//                    navController.navigate(route = AboutRoute)
//                }
//            )
        }

        composable<DetailScreenRoute>{ it ->
            val args = it.toRoute<DetailScreenRoute>()
            SampleItems.find { it.id == args.id }?.let {
                DetailScreen(it,
                    onClickToSearchScreen = {
                        navController.navigate(route = SearchScreenRoute)
                    }
                )
            }
//            DetailScreen(args.id,
//                onClickToSearchScreen = {
//                    navController.navigate(route = HomeScreenRoute)
//                }
//            )
        }
//        composable<AboutRoute>{
//            AboutScreen(onNavigateToHome = {
//                navController.navigate(route = HomeRoute)
//            },onNavigateToAbout = {})
//        }
    }

}