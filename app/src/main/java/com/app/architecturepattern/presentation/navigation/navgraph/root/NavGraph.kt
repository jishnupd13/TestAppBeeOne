package com.app.architecturepattern.presentation.navigation.navgraph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.architecturepattern.presentation.navigation.routes.ROUTE_GRAPH_ROOT
import com.app.architecturepattern.presentation.navigation.routes.Routes
import com.app.architecturepattern.presentation.ui.home.HomeScreen
import com.app.architecturepattern.presentation.ui.login.LoginScreen

@Composable
fun SetUpNavGraph(
    navHostController: NavHostController,
    startDestination:String
) {

    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        route = ROUTE_GRAPH_ROOT
    ) {
        composable(Routes.Login.route) {
            LoginScreen(navHostController = navHostController)
        }

        composable(Routes.HomeScreen.route) {
            HomeScreen(navHostController = navHostController)
        }
    }
}