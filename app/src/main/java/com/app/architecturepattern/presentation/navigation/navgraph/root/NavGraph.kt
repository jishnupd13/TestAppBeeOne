package com.app.architecturepattern.presentation.navigation.navgraph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.architecturepattern.presentation.navigation.navgraph.home.homeNavGraph
import com.app.architecturepattern.presentation.navigation.routes.HOME_GRAPH_ROOT
import com.app.architecturepattern.presentation.navigation.routes.ROUTE_GRAPH_ROOT
import com.app.architecturepattern.presentation.navigation.routes.Routes
import com.app.architecturepattern.presentation.ui.datastore.DataStoreImplementationScreen

@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = Routes.DataStoreScreen.route,
        route = ROUTE_GRAPH_ROOT
    ) {
        composable( Routes.DataStoreScreen.route){
            DataStoreImplementationScreen()
        }
        homeNavGraph(navHostController = navHostController)
    }
}