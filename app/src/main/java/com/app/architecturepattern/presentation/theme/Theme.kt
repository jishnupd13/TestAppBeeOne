package com.app.architecturepattern.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = LightBlue,
    primaryVariant = LightBlue,
    secondary = White
)

private val LightColorPalette = lightColors(
    primary = LightBlue,
    primaryVariant = LightBlue,
    secondary = LightBlue

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ArchitecturePatternTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    /*val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }*/

    //For disable the dark theme
    val colors = LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = QuickSandTypography,
        shapes = Shapes,
        content = content
    )
}