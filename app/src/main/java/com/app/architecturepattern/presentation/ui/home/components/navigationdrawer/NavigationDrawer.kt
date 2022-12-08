package com.app.architecturepattern.presentation.ui.home.components.navigationdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.architecturepattern.presentation.theme.QuickSand

@Composable
fun NavigationContent(
    onItemClick: () -> Unit
) {

    Column() {

        Spacer(modifier = Modifier.height(14.dp))

        Row() {

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .background(color = Color.Black, shape = CircleShape),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "T",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontFamily = QuickSand,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = "Machine Test",
            fontFamily = QuickSand,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 8.dp),
            color = Color.Black
        )
        Text(
            text = "BeeOne",
            fontWeight = FontWeight.Medium,
            fontFamily = QuickSand,
            modifier = Modifier.padding(start = 8.dp, top = 0.5.dp),
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            modifier = Modifier
                .height(0.5.dp), color = Color.Gray
        )

        NavigationBody(onItemClick)

    }
}


@Composable
fun NavigationBody(
    onItemClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            Text(
                text = "Exit",
                fontFamily = QuickSand,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(14.dp)
                    .clickable {
                        onItemClick()
                    },
                color = Color.Black
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun NavigationDrawerPreview() {
    NavigationContent {}
}