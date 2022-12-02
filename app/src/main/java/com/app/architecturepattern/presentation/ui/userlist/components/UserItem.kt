package com.app.architecturepattern.presentation.ui.userlist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.architecturepattern.data.remote.dto.Company
import com.app.architecturepattern.domain.model.User

@Composable
fun UserItem(user: User) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "id : ${user.id}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, end = 14.dp),
            fontSize = 14.sp
        )

        Text(
            text = "name : ${user.name}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, end = 14.dp, top = 6.dp),
            fontSize = 14.sp
        )

        Text(
            text = "phone : ${user.phone}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, end = 14.dp, top = 6.dp),
            fontSize = 14.sp
        )

        Text(
            text = "email : ${user.email}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, end = 14.dp, top = 6.dp),
            fontSize = 14.sp
        )

        Text(
            text = "company : ${user.company?.name ?: ""}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, end = 14.dp, top = 6.dp),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(14.dp))

        Divider(
            modifier = Modifier
                .height(0.5.dp)
                .background(Color.Gray)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun UserItemPreview() {
    UserItem(
        User(
            id = 1,
            "Jishnu P Dileep",
            "",
            "",
            company = Company()

        )
    )
}