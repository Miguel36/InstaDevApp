package com.skyfallen.instadev.ui.auth.login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skyfallen.instadev.domain.auth.login.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState : StateFlow<LoginUiState> = _uiState

    fun onEmailChanged(email: String) {
        _uiState.update { state ->
            state.copy(email = email)
        }
        validateLogin()
    }

    fun onPasswordChanged(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
        validateLogin()
    }

    fun onClickLogin() {
        viewModelScope.launch {
            val response = loginUseCase(_uiState.value.email, _uiState.value.password)

            if (response != null) {
                Log.i("Login", "Login success ${response.name}")
            }
            else {
                Log.e("Login", "Login error")
            }
        }
    }

    private fun validateLogin() {
        val isValid = isEmailValid(_uiState.value.email) && isPassValid(_uiState.value.password)
        _uiState.update { it.copy(isLoginEnabled = isValid) }
    }

    private fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isPassValid(pass: String): Boolean = pass.length >= 8
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false
)