package com.app.architecturepattern.presentation.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.architecturepattern.presentation.ui.home.components.navigationdrawer.NavigationContent
import com.app.architecturepattern.presentation.ui.home.components.topbar.AppBar
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navHostController: NavHostController
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        content = {
            Scaffold(
                topBar = {
                    AppBar {
                        if (drawerState.isClosed) {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        } else {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        }
                    }
                },
                content = {
                    val params = it
                    Text(modifier = Modifier.padding(params), text = "")
                }
            )

        },
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.White,
            ) {
                NavigationContent {
                    coroutineScope.launch {
                        drawerState.close()
                    }
                }
            }
        },
        gesturesEnabled = true,

        )


}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}