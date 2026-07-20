package com.spensei.app.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.spensei.app.presentation.screens.addEdit.AddEditExpenseScreen
import com.spensei.app.presentation.screens.auth.LoginScreen
import com.spensei.app.presentation.screens.categories.CategoriesScreen
import com.spensei.app.presentation.screens.dashboard.DashboardScreen
import com.spensei.app.presentation.screens.home.HomeScreen
import com.spensei.app.presentation.screens.settings.SettingsScreen

@Composable
fun SpenseiApp (){
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val bottomNavRoutes = bottomNavItems.map { it.screen.route }

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomNavRoutes){
                NavigationBar {
                    bottomNavItems.forEach { item->
                        NavigationBarItem(
                            selected = currentRoute == item.screen.route,
                            onClick = {
                               navController.navigate(item.screen.route){
                                   popUpTo(Screen.Home.route){
                                       saveState = true
                                   }
                                   launchSingleTop = true
                                   restoreState = true
                               }
                            },
                            icon = { Icon(item.icon, contentDescription = item.label) },
                            label = { Text(item.label) }
                        )
                    }
                }
            }
        }
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Login.route) {
                LoginScreen(
                    onSignInClick = {
                        // TODO Day 8: real sign-in check happens before this navigate() call
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Login.route) { inclusive = true }
                        }
                    }
                )
            }

            composable(Screen.Home.route) {
                HomeScreen(
                    onAddExpenseClick = {
                        navController.navigate(Screen.AddEditExpense.createRoute())
                    },
                    onExpenseClick = { expenseId ->
                        navController.navigate(Screen.AddEditExpense.createRoute(expenseId))
                    }
                )
            }

            composable(
                route = Screen.AddEditExpense.route,
                arguments = listOf(navArgument("expenseId") {
                    type = NavType.StringType
                    nullable = true
                })
            ) { entry ->
                val expenseId = entry.arguments?.getString("expenseId")?.toLongOrNull()
                AddEditExpenseScreen(
                    expenseId = expenseId,
                    onDone = { navController.popBackStack() }
                )
            }

            composable(Screen.Dashboard.route) { DashboardScreen() }
            composable(Screen.Categories.route) { CategoriesScreen() }
            composable(Screen.Settings.route) { SettingsScreen() }
        }

    }
}