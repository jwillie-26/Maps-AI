package com.example.mapsai.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.yourapp.mapsai.data.model.Preference
import com.yourapp.mapsai.data.model.Place
import kotlinx.coroutines.tasks.await

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

val auth: FirebaseAuth = FirebaseAuth.getInstance()
val db: FirebaseFirestore = FirebaseFirestore.getInstance()

class UserRepository(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance(),
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
    private val usersCollection = db.collection("users")

    fun getCurrentUserId(): String? = auth.currentUser?.uid

    // Save preferences to Firestore
    suspend fun savePreferences(preferences: List<Preference>) {
        val uid = getCurrentUserId() ?: return
        usersCollection.document(uid)
            .collection("preferences")
            .document("userPrefs")
            .set(mapOf("prefs" to preferences.map { it.name }))
            .await()
    }

    // Get preferences
    suspend fun getPreferences(): List<String> {
        val uid = getCurrentUserId() ?: return emptyList()
        val snapshot = usersCollection.document(uid)
            .collection("preferences")
            .document("userPrefs")
            .get()
            .await()

        return snapshot.get("prefs") as? List<String> ?: emptyList()
    }

    // Save a favorite place
    suspend fun saveFavorite(place: Place) {
        val uid = getCurrentUserId() ?: return
        usersCollection.document(uid)
            .collection("favorites")
            .document(place.id)
            .set(place)
            .await()
    }

    // Get all favorites
    suspend fun getFavorites(): List<Place> {
        val uid = getCurrentUserId() ?: return emptyList()
        val snapshot = usersCollection.document(uid)
            .collection("favorites")
            .get()
            .await()

        return snapshot.toObjects(Place::class.java)
    }
}