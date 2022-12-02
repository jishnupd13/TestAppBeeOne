package com.app.architecturepattern.presentation.ui.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.architecturepattern.presentation.theme.QuickSand

@Composable
fun TopBarScreen(title: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            color = Color.Black, fontSize = 17.sp,
            fontFamily = QuickSand,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 14.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable()
fun TopBarScreenPreview() {
    TopBarScreen("Login")
}