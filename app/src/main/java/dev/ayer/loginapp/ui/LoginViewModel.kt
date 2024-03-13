package dev.ayer.loginapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ayer.loginapp.domain.LoginUseCaseImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    //private val loginUseCase: LoginUseCase,
): ViewModel() {

    private val loginUseCase = LoginUseCaseImpl()
    private val mutableState = MutableStateFlow(LoginScreenState())
    val state: StateFlow<LoginScreenState> get() = mutableState

    fun login(userName: String, password: String) = viewModelScope.launch {
        val newValue = mutableState.value.copy(
            isLoading = true,
            success = false, // Added after
            errorMessage = null // Added after
        )
        mutableState.emit(newValue)

        val result = loginUseCase.invoke(userName = userName, password = password)
        if (result != null) {
            val newValue = mutableState.value.copy(
                success = true,
                isLoading = false,
                errorMessage = null
            )
            mutableState.emit(newValue)
        } else {
            val newValue = mutableState.value.copy(
                errorMessage = "wrong password",
                isLoading = false,
                success = false, // Added after
            )
            mutableState.emit(newValue)
        }
    }

    fun onUserNameInputChanged(userName: String) = viewModelScope.launch {
        val newValue = mutableState.value.copy(
            userNameFieldValue = userName
        )
        mutableState.emit(newValue)
    }

    fun onPasswordInputChanged(password: String) = viewModelScope.launch {
        val newValue = mutableState.value.copy(
            passwordFieldValue = password
        )
        mutableState.emit(newValue)
    }
}