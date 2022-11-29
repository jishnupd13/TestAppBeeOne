package com.app.architecturepattern.presentation.navigation.navgraph.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.architecturepattern.presentation.navigation.routes.HOME_GRAPH_ROOT
import com.app.architecturepattern.presentation.navigation.routes.Routes
import com.app.architecturepattern.presentation.ui.userlist.screens.UserListScreen

fun NavGraphBuilder.homeNavGraph(
    navHostController: NavHostController
) {

    navigation(
        startDestination = Routes.Home.route,
        route = HOME_GRAPH_ROOT
    ) {
        composable(Routes.Home.route) {
            UserListScreen()
        }

    }


}