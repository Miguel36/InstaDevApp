package com.skyfallen.instadev.view.auth.login

import androidx.compose.foundation.Image
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skyfallen.instadev.R

@Preview
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Español (España)", modifier = Modifier.padding(24.dp))
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "Instadev logo login",
                modifier = Modifier .size(72.dp)
            )
            Spacer(Modifier.weight(1f))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.email,
                onValueChange = { email -> loginViewModel.onEmailChanged(email) },
                label = { Text("Usuario, correo electrónico o móvil") },
                shape = RoundedCornerShape(25)
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.password,
                onValueChange = { pass -> loginViewModel.onPasswordChanged(pass) },
                label = { Text("Contraseña") },
                shape = RoundedCornerShape(25)
            )
            Spacer(Modifier.height(10.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                onClick = {},
                enabled = uiState.isLoginEnabled) {
                Text("Iniciar sesión")
            }
            Spacer(Modifier.height(12.dp))
            Text("¿Has olvidado la contraseña?")
            Spacer(Modifier.weight(1f))

            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) { Text("Crear cuenta nueva") }
            Icon(
                painter = painterResource(R.drawable.meta_logo),
                contentDescription = "Meta icon",
                tint = Color.Gray,
                modifier = Modifier.width(70.dp)
            )
        }
    }

}