package com.example.mapsai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mapsai.data.model.Place
import com.example.mapsai.screens.preference.PreferencesScreen
import com.example.mapsai.screens.home.HomeScreen
import com.example.mapsai.screens.profile.ProfileScreen
import com.example.mapsai.screens.detail.PlaceDetailScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "preferences"
    ) {
        // Preferences screen
        composable("preferences") {
            PreferencesScreen(navController = navController)
        }

        // Home screen
        composable("home") {
            HomeScreen(navController = navController)
        }

        // Profile screen
        composable("profile") {
            val userName = "Demo User"
            val prefs = listOf("Restaurants", "Parks") // Example hardcoded prefs

            ProfileScreen(
                userName = userName,
                preferences = prefs,
                onLogout = { navController.navigate("preferences") }
            )
        }

        // Place Detail screen with arguments
        composable(
            route = "placeDetail/{placeName}/{placeDesc}",
            arguments = listOf(
                navArgument("placeName") { type = NavType.StringType },
                navArgument("placeDesc") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("placeName") ?: ""
            val desc = backStackEntry.arguments?.getString("placeDesc") ?: ""

            val place = Place(
                id = "1",
                name = name,
                description = desc
            )

            PlaceDetailScreen(
                place = place,
                onSave = { /* TODO: save to favorites in Firestore later */ }
            )
        }
    }
}
