package com.skyfallen.instadev.ui.auth.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState


    fun onRegisterChanged(value: String) {
        _uiState.update {
            val isValid = isRegisterValid(value, it.isRegisterWithNumber)
            it.copy(
                textFieldValue = value,
                isRegisterEnabled = isValid
            )
        }
    }

    private fun isRegisterValid(value: String, isNumber: Boolean): Boolean {
        return if (isNumber)
            (Patterns.PHONE.matcher(value).matches() && value.length == 10)
        else
            Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }

    fun onChangeRegisterType() {
        _uiState.update {
            it.copy(
                isRegisterWithNumber = !uiState.value.isRegisterWithNumber,
                textFieldValue = "",
                isRegisterEnabled = false
            )
        }
    }
}

data class RegisterUiState(
    val textFieldValue: String = "",
    val isRegisterEnabled: Boolean = false,
    val isRegisterWithNumber: Boolean = true
)