package com.skyfallen.instadev.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skyfallen.instadev.ui.auth.login.LoginScreen
import com.skyfallen.instadev.ui.auth.register.RegisterScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateToRegister = { navController.navigate(Register) })
        }

        composable<Register> {
            RegisterScreen()
        }
    }
}