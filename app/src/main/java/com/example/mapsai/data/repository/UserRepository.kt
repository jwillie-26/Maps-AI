package com.example.mapsai.data.repository

import com.example.mapsai.data.model.Place
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {

    // Simulated user preferences (in real case, fetch from Firestore or SharedPreferences)
    private val userPreferences = listOf("restaurant", "park", "museum")

    // Simulated favorites list (replace with Firestore/Room in real app)
    private val favorites = mutableListOf<Place>()

    // Get user preferences (categories of interest)
    suspend fun getPreferences(): List<String> = withContext(Dispatchers.IO) {
        // TODO: Replace with Firestore/SharedPreferences logic
        userPreferences
    }

    // Save a favorite place for the user
    suspend fun saveFavorite(place: Place) = withContext(Dispatchers.IO) {
        // TODO: Replace with Firestore/Room database logic
        favorites.add(place)
    }

    // Optional: Get all saved favorites
    suspend fun getFavorites(): List<Place> = withContext(Dispatchers.IO) {
        favorites.toList()
    }
}
