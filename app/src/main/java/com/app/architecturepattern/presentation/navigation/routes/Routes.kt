package com.app.architecturepattern.presentation.navigation.routes


const val ROUTE_GRAPH_ROOT = "root"
const val HOME_GRAPH_ROOT = "home"

sealed class Routes(val route: String) {
    object Home : Routes("user_list_screen")
    object DataStoreScreen : Routes("data_store_user")
    object Login : Routes("login")
    object HomeScreen : Routes("home_screen")
}
