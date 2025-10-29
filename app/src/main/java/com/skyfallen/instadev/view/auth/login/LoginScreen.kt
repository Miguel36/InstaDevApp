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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skyfallen.instadev.R

@Preview
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var textValue by remember { mutableStateOf("") }

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
                modifier = modifier.size(72.dp)
            )
            Spacer(Modifier.weight(1f))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = textValue,
                onValueChange = { value -> textValue = value },
                label = { Text("Usuario, correo electrónico o móvil") },
                shape = RoundedCornerShape(25)
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = textValue,
                onValueChange = { value -> textValue = value },
                label = { Text("Contraseña") },
                shape = RoundedCornerShape(25)
            )
            Spacer(Modifier.height(10.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                onClick = {}) {
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