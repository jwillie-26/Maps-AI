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
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "preferences"
    ) {
        // Preferences screen expects NavController
        composable("preferences") {
            PreferencesScreen(navController = navController)
        }

        // Home screen expects NavController
        composable("home") {
            HomeScreen(navController = navController)
        }

        // Profile screen expects NavController (it will read Firestore / auth itself)
        composable("profile") {
            ProfileScreen(navController = navController)
        }

        // Place Detail screen with arguments (we decode them to handle spaces)
        composable(
            route = "placeDetail/{placeName}/{placeDesc}",
            arguments = listOf(
                navArgument("placeName") { type = NavType.StringType },
                navArgument("placeDesc") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val rawName = backStackEntry.arguments?.getString("placeName") ?: ""
            val rawDesc = backStackEntry.arguments?.getString("placeDesc") ?: ""
            val name = URLDecoder.decode(rawName, StandardCharsets.UTF_8.name())
            val desc = URLDecoder.decode(rawDesc, StandardCharsets.UTF_8.name())

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
