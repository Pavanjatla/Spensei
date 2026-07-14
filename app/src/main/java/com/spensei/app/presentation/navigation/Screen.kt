package com.spensei.app.presentation.navigation

sealed class Screen (val route : String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object AddEditExpense : Screen("add_edit_expense?expenseId={expenseId}") {
        fun createRoute(expenseId: Long? = null) =
            "add_edit_expense" + (expenseId?.let { "?expenseId=$it" } ?: "")
    }
    object Dashboard : Screen("dashboard")
    object Categories : Screen("categories")
    object Settings : Screen("settings")
}