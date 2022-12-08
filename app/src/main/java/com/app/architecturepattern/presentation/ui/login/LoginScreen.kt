package com.app.architecturepattern.presentation.ui.login

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.architecturepattern.presentation.navigation.routes.Routes
import com.app.architecturepattern.presentation.theme.LightBlue
import com.app.architecturepattern.presentation.theme.QuickSand
import com.app.architecturepattern.presentation.theme.UnFocusedColor
import com.app.architecturepattern.presentation.theme.White
import com.app.architecturepattern.presentation.ui.login.components.LoginViewModel
import com.app.architecturepattern.presentation.ui.login.components.TopBarScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navHostController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }



    Scaffold(
        topBar = { TopBarScreen("Login") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .animateContentSize()
        ) {


            OutlinedTextField(
                value = viewModel.email.value,
                onValueChange = {
                    viewModel.email.value = it
                },
                label = {
                    Text(text = "Email")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = LightBlue,
                    unfocusedBorderColor = UnFocusedColor
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp, end = 14.dp, top = 60.dp),
                singleLine = true,
                supportingText = {
                    AnimatedVisibility(
                        visible = viewModel.emailValidationStatus.value,
                        enter = slideInVertically() + fadeIn(initialAlpha = 0.3f),
                        exit = slideOutVertically() + fadeOut()
                    ) {
                        Text(text = "Invalid Email", color = Color.Red)

                    }
                },
                isError = viewModel.emailValidationStatus.value
            )

            OutlinedTextField(
                value = viewModel.password.value,
                onValueChange = {
                    viewModel.password.value = it
                },
                label = {
                    Text(text = "Password")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = LightBlue,
                    unfocusedBorderColor = UnFocusedColor
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp, end = 14.dp, top = 14.dp),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff
                    val description = if (passwordVisible) "Hide password" else "Show password"
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                },
                supportingText = {
                    AnimatedVisibility(
                        visible = viewModel.passwordValidationStatus.value,
                        enter = slideInVertically() + fadeIn(initialAlpha = 0.3f),
                        exit = slideOutVertically() + fadeOut()
                    ) {
                        Text(text = "Invalid Password", color = Color.Red)

                    }
                },
                isError = viewModel.passwordValidationStatus.value
            )

            Button(
                onClick = {
                    viewModel.validateLogin()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp, end = 14.dp, top = 14.dp),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Submit",
                    fontFamily = QuickSand,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = White,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                )
            }

            LaunchedEffect(key1 = true ){
                if (viewModel.navigationStatus.value) {
                    navHostController.navigate(Routes.HomeScreen.route)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}