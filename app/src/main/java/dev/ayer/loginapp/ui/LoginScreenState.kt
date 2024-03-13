package dev.ayer.loginapp.ui

data class LoginScreenState(
    val userNameFieldValue: String = "",
    val passwordFieldValue: String = "",
    val isLoading: Boolean = false,
    val success: Boolean = false,
    val errorMessage: String? = null,
)