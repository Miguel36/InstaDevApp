package com.skyfallen.instadev.ui.auth.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState


    fun onCellPhoneChanged(phoneNumber: String) {
        _uiState.update {
            it.copy(textFieldValue = phoneNumber)
        }
        validateRegister()
    }

    private fun validateRegister() {
        val isValid = isCellPhoneValid()
        _uiState.update { it.copy(isRegisterEnabled = isValid) }
    }

    private fun isCellPhoneValid(): Boolean = Patterns.PHONE.matcher(_uiState.value.textFieldValue)
        .matches() && _uiState.value.textFieldValue.length == 10

    fun onChangeRegisterType() {
        _uiState.update {
            it.copy(isRegisterWithNumber = !uiState.value.isRegisterWithNumber, textFieldValue = "", isRegisterEnabled = false)
        }
    }
}

data class RegisterUiState(
    val textFieldValue: String = "",
    val isRegisterEnabled: Boolean = false,
    val isRegisterWithNumber: Boolean = true
)