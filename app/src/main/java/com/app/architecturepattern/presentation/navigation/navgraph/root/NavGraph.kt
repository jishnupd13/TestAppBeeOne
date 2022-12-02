package com.app.architecturepattern.presentation.navigation.navgraph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.architecturepattern.presentation.ui.login.LoginScreen
import com.app.architecturepattern.presentation.navigation.routes.ROUTE_GRAPH_ROOT
import com.app.architecturepattern.presentation.navigation.routes.Routes

@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = Routes.Login.route,
        route = ROUTE_GRAPH_ROOT
    ) {
        composable(Routes.Login.route) {
            LoginScreen(navHostController = navHostController)
        }

    }
}