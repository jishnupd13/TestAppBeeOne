package com.app.architecturepattern.presentation.navigation.navgraph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.app.architecturepattern.presentation.navigation.navgraph.home.homeNavGraph
import com.app.architecturepattern.presentation.navigation.routes.HOME_GRAPH_ROOT
import com.app.architecturepattern.presentation.navigation.routes.ROUTE_GRAPH_ROOT

@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = HOME_GRAPH_ROOT,
        route = ROUTE_GRAPH_ROOT
    ) {
        homeNavGraph(navHostController = navHostController)
    }
}