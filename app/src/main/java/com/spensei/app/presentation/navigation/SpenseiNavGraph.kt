package com.spensei.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.spensei.app.presentation.screens.auth.LoginScreen

@Composable
fun SpenseiNavGraph(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(Screen.Login.route) {
            LoginScreen(
                onSignInClick = {
                    // TODO Day 8: real sign-in, then:
                    // navController.navigate(Screen.Home.route) {
                    //     popUpTo(Screen.Login.route) { inclusive = true }
                    // }
                }
            )
        }
    }
}