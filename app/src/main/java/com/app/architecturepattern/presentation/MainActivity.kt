package com.app.architecturepattern.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.architecturepattern.presentation.navigation.navgraph.root.SetUpNavGraph
import com.app.architecturepattern.presentation.theme.ArchitecturePatternTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navHostController = rememberNavController()
            ArchitecturePatternTheme {
                SetUpNavGraph(navHostController = navHostController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArchitecturePatternTheme {
        SetUpNavGraph(navHostController = rememberNavController())
    }
}
