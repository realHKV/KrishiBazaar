package com.example.krishibazaar.Navigation

import kotlinx.serialization.Serializable


@Serializable
object HomeScreenRoute

@Serializable
object SearchScreenRoute

@Serializable
data class DetailScreenRoute(
    val id: Int
)

@Serializable
object WeatherScreenRoute

@Serializable
object RentScreenRoute

@Serializable
object CartScreenRoute

@Serializable
object SellScreenRoute

@Serializable
object ChatBotScreenRoute

@Serializable
object LocationScreenRoute

@Serializable
object CategoryScreenRoute

@Serializable
object AboutScreenRoute

@Serializable
object SignInRoute

@Serializable
object SignUpRoute

@Serializable
object UploadItemForSaleScreenRoute

@Serializable
object InfoScreenRoute

@Serializable
object EditScreenRoute

@Serializable
object SettingsScreenRoute



@Serializable
object MandiRateScreenRoute
data class screenRoutes(
    val HomeScreenRoute: String,
    val MandiRateScreenRoute: String,
    val SearchScreenRoute: String,
    val CartScreenRoute: String,
    val ProfileScreenRoute: String,
    val AboutScreenRoute: String,
    val RentScreenRoute: String
)