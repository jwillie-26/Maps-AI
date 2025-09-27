package com.example.mapsai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mapsai.screens.preference.PreferencesScreen
import com.example.mapsai.screens.home.HomeScreen  // <- if you already created HomeScreen.kt

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "preferences"
    ) {
        composable("preferences") {
            PreferencesScreen(navController = navController)
        }
        composable("home") {
            HomeScreen() // <-- Replace with your actual HomeScreen
        }
    }
}
