package com.skyfallen.instadev.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

/**
 * Crear componentes propios de esta forma, ayuda a poder reutilizar el componente en muchas partes
 * del código manteniendo la misma estructura y evita que nos olvidemos de poner alguna propiedad
 */

@Composable
fun InstaButton(
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.secondary
    ),
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    text: String
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = colors,
        enabled = enabled,
        shape = shape
    ) {
        InstaText(text = text, color = MaterialTheme.colorScheme.onPrimary)
    }
}

@Composable
fun InstaButtonSecondary(
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.secondary
    ),
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    text: String
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        colors = colors,
        shape = shape
    ) {
        Text(text = text, color = MaterialTheme.colorScheme.onSecondary)
    }
}

@Composable
fun InstaButtonTertiary(
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.tertiary
    ),
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    text: String
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        colors = colors,
        shape = shape
    ) {
        Text(text = text, color = MaterialTheme.colorScheme.onTertiary)
    }
}