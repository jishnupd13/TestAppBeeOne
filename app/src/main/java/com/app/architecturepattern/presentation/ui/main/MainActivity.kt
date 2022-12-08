package com.app.architecturepattern.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.architecturepattern.presentation.navigation.navgraph.root.SetUpNavGraph
import com.app.architecturepattern.presentation.navigation.routes.Routes
import com.app.architecturepattern.presentation.theme.ArchitecturePatternTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {

        }

        setContent {

            navHostController = rememberNavController()
            ArchitecturePatternTheme(darkTheme = false) {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color.White,
                        darkIcons = true
                    )
                }


                if (viewModel.isLoading.value.isNotEmpty()) {
                    SetUpNavGraph(navHostController = navHostController, viewModel.isLoading.value)
                }
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArchitecturePatternTheme {
        SetUpNavGraph(navHostController = rememberNavController(), Routes.Login.route)
    }
}
