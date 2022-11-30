package com.app.architecturepattern.presentation.ui.datastore

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DataStoreImplementationScreen(
    viewModel: DataStoreImplementationViewModel = hiltViewModel()
) {
    val name = viewModel.state

    Box(modifier = Modifier.fillMaxSize()) {

        var text by remember { mutableStateOf("") }

        Column(modifier = Modifier.fillMaxSize()) {
            TextField(
                value = text, onValueChange = {
                    text = it
                },
                label = {
                    Text(text = "Enter the name")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, start = 14.dp, end = 14.dp)
            )

            Button(onClick = {
                viewModel.saveUserName(text)
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, end = 14.dp, top = 10.dp)) {
                Text(text = "Save")
            }

            Button(onClick = {
                viewModel.fetchUserName()
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, end = 14.dp, top = 10.dp)) {
                Text(text = "Read")
            }

            Text(text = name.value, modifier = Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp, top = 10.dp), color = Color.Cyan)
        }
    }

}

@Composable
@Preview(showBackground = true)
fun DataStoreImplementationScreenPreview() {
    DataStoreImplementationScreen()
}