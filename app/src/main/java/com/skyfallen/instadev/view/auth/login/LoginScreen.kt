package com.skyfallen.instadev.view.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var textValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Español (España)")
        Icon(
            imageVector = Icons.Default.AccountBalance,
            contentDescription = "",
            modifier = modifier.size(80.dp).background(brush = Brush.linearGradient(listOf(Color.White, Color.Red.copy(0.02f), Color.White))),
            tint = Color.Red
        )

        Column(
            Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = textValue,
                onValueChange = { value -> textValue = value },
                label = { Text("Usuario, correo electrónico o móvil") },
                shape = RoundedCornerShape(25)
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = textValue,
                onValueChange = { value -> textValue = value },
                label = { Text("Contraseña") },
                shape = RoundedCornerShape(25)
            )
            Spacer(Modifier.height(12.dp))
            Button(modifier = Modifier.fillMaxWidth(), onClick = {}) { Text("Iniciar sesión") }
            Text("¿Has olvidado la contraseña?")
        }



        OutlinedButton(onClick = {}) { Text("Crear cuenta nueva") }

    }
}