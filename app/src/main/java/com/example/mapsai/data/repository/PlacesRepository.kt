package com.example.mapsai.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.example.mapsai.data.model.Place
import kotlinx.coroutines.tasks.await

class PlacesRepository(
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
    private val placesCollection = db.collection("places")

    // Get places filtered by category (user preferences)
    suspend fun getPlacesByPreferences(preferences: List<String>): List<Place> {
        if (preferences.isEmpty()) return emptyList()

        val snapshot = placesCollection
            .whereIn("category", preferences)
            .get()
            .await()

        return snapshot.documents.mapNotNull { it.toObject(Place::class.java) }
    }

    // Get all places
    suspend fun getAllPlaces(): List<Place> {
        val snapshot = placesCollection.get().await()
        return snapshot.documents.mapNotNull { it.toObject(Place::class.java) }
    }
}
