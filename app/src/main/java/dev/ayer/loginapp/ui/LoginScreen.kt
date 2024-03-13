package dev.ayer.loginapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
) {
    val state = viewModel.state.collectAsState()
    val userName = state.value.userNameFieldValue
    val password = state.value.passwordFieldValue
    val error = state.value.errorMessage
    val isLoading = state.value.isLoading
    val isSuccess = state.value.success

    Column {
        TextField(value = userName, onValueChange = { newUserNameValue ->
            viewModel.onUserNameInputChanged(newUserNameValue)
        })

        TextField(value = password, onValueChange = { newPasswordValue ->
            viewModel.onPasswordInputChanged(newPasswordValue)
        })

        if (error != null) {
            Text(text = error)
        }

        if(isSuccess) Text(text = "Success") // Added after
        if (isLoading) CircularProgressIndicator() // Added after

        Button(
            enabled = !isLoading,
            onClick = {
                viewModel.login(
                    userName = userName,
                    password = password,
                )
            },
        ) {
            Text(text  = "Login")
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    //LoginScreen(LoginViewModel())
}