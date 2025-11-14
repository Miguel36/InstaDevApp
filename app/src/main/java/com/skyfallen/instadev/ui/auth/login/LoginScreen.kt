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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skyfallen.instadev.R
import com.skyfallen.instadev.ui.components.InstaButton
import com.skyfallen.instadev.ui.components.InstaText

@Preview
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
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
                text = "Español (España)",
                modifier = Modifier.padding(24.dp),
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "Instadev logo login",
                modifier = Modifier.size(72.dp)
            )
            Spacer(Modifier.weight(1f))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.email,
                onValueChange = { email -> loginViewModel.onEmailChanged(email) },
                label = {
                    InstaText(text = "Usuario, correo electrónico o móvil")
                },
                shape = RoundedCornerShape(25)
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.password,
                onValueChange = { pass -> loginViewModel.onPasswordChanged(pass) },
                label = { InstaText(text = "Contraseña") },
                shape = RoundedCornerShape(25)
            )
            Spacer(Modifier.height(10.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                onClick = {},
                enabled = uiState.isLoginEnabled,
                text = "Iniciar sesión"
            )
            Spacer(Modifier.height(12.dp))
            InstaText(
                text = "¿Has olvidado la contraseña?",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.weight(1f))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) { InstaText(text = "Crear cuenta nueva", color = MaterialTheme.colorScheme.primary) }
            Icon(
                painter = painterResource(R.drawable.meta_logo),
                contentDescription = "Meta icon",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.width(70.dp)
            )
        }
    }

}