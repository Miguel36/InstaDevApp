package com.skyfallen.instadev.ui.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.skyfallen.instadev.R
import com.skyfallen.instadev.ui.components.InstaButton
import com.skyfallen.instadev.ui.components.InstaText
import com.skyfallen.instadev.ui.components.InstaTextField

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = hiltViewModel(), navigateToRegister: () -> Unit) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InstaText(
                text = stringResource(R.string.login_header_language_spain),
                modifier = Modifier.padding(24.dp),
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "Instadev logo login",
                modifier = Modifier.size(72.dp)
            )
            Spacer(Modifier.weight(1f))

            InstaTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.email,
                onValueChange = { email -> loginViewModel.onEmailChanged(email) },
                label = stringResource(R.string.login_textfield_email),
                shape = RoundedCornerShape(25)
            )
            InstaTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.password,
                onValueChange = { pass -> loginViewModel.onPasswordChanged(pass) },
                label = stringResource(R.string.login_textfield_password),
                shape = RoundedCornerShape(25)
            )
            Spacer(Modifier.height(10.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { loginViewModel.onClickLogin() },
                enabled = uiState.isLoginEnabled,
                text = stringResource(R.string.login_button_login)
            )
            Spacer(Modifier.height(12.dp))
            InstaText(
                text = stringResource(R.string.login_text_forgot_password),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.weight(1f))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navigateToRegister() },
                colors = ButtonDefaults.outlinedButtonColors(),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                InstaText(
                    text = stringResource(R.string.login_button_create_new_account),
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Icon(
                painter = painterResource(R.drawable.meta_logo),
                contentDescription = "Meta icon",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.width(70.dp)
            )
        }
    }

}