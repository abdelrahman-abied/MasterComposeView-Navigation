package com.example.sampleapp.third_activity


import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationBackStack() {

    // Create a NavHostController
    val navController = rememberNavController()

    // Get the hosting Activity
    val activity = LocalActivity.current as? ComponentActivity // Get the hosting Activity

    // Observe the current back stack entry to get the current route
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Get the current route
    val currentRoute = navBackStackEntry?.destination?.route

    NavHost(navController = navController, startDestination = Screen.First.route) {

        composable(route = Screen.First.route) {

            FirstComposeScreen(navController)
        }
        composable(
            route = Screen.Second.route + "?text={text}",
            arguments = listOf(
                navArgument("text") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            SecondComposeScreen(
                navController = navController,
                text = it.arguments?.getString("text")
            )
        }
    }
}

@Preview(name = "NavigationBackStack")
@Composable
private fun PreviewNavigationBackStack() {
    NavigationBackStack()
}

// Screen.kt
sealed class Screen(val route: String) {
    object First : Screen("first_screen")
    object Second : Screen("second_screen")
}