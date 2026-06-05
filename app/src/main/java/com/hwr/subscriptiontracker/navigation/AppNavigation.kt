package com.hwr.subscriptiontracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hwr.subscriptiontracker.screen.LoginScreen
import com.hwr.subscriptiontracker.screen.MainScreen
import com.hwr.subscriptiontracker.screen.RegisterScreen
import com.hwr.subscriptiontracker.screen.StartScreen

@Composable
fun AppNavigation(
    onLoginSuccess: () -> Unit,
    onRegisterSuccess: () -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "start"
    ) {
        composable("start") {
            StartScreen(
                onNavigateToLogin = {
                    navController.navigate("login")
                },
                onNavigateToRegister = {
                    navController.navigate("register")
                },
                onNavigateToMain = {
                    navController.navigate("main")
                }
            )
        }
        composable("login") {
            LoginScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onLoginSuccess = {
                    navController.navigate("main")
                    onLoginSuccess()
                }
            )
        }
        composable("register") {
            RegisterScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onRegisterSuccess = {
                    navController.navigate("main")
                    onRegisterSuccess()
                }
            )
        }
        composable("main") {
            MainScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}