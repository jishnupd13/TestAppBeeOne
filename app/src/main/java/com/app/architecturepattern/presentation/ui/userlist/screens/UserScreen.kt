package com.app.architecturepattern.presentation.ui.userlist.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.architecturepattern.presentation.ui.userlist.UserListViewModel
import com.app.architecturepattern.presentation.ui.userlist.components.UserItem

@Composable
fun UserListScreen(
    viewModel: UserListViewModel = hiltViewModel()
) {


    val state = viewModel.state.value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(14.dp))

        LazyColumn {
            item {
                Text(
                    text = "User List",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 14.dp, end = 14.dp)
                        .align(Alignment.Center)
                )
            }

            items(state.users) { item ->
                UserItem(user = item)
            }
        }

        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UserListScreenPreview() {
    UserListScreen()
}