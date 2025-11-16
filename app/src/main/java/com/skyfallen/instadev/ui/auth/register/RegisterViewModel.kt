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
            it.copy(cellphone = phoneNumber)
        }
        validateRegister()
    }

    private fun validateRegister() {
        val isValid = isCellPhoneValid()
        _uiState.update { it.copy(isRegisterEnabled = isValid) }
    }

    private fun isCellPhoneValid(): Boolean = Patterns.PHONE.matcher(uiState.value.cellphone)
        .matches() && uiState.value.cellphone.length == 10
}

data class RegisterUiState(
    val cellphone: String = "",
    val isRegisterEnabled: Boolean = false
)