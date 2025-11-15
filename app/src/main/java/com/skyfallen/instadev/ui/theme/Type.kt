package com.skyfallen.instadev.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.skyfallen.instadev.R

val loraFamily = FontFamily(
    // Aqui podemos crear las variaciones en peso de nuestra fuente
    Font(R.font.lora_regular, FontWeight.Normal)
)

val Typography = Typography(
    bodyLarge = TextStyle(
//        fontFamily = loraFamily, /* Asignamos la fuente añadida al proyecto */
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontSize = 36.sp,
        fontFamily = loraFamily,
        fontWeight = FontWeight.Light
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)