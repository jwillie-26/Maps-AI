package com.example.mapsai.screens.preference



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun PreferencesScreen(navController: NavController) {
    val db = FirebaseFirestore.getInstance()

    // Example categories
    val categories = listOf("Restaurants", "Parks", "Museums", "Cafes", "Hotels")

    // State to track selected categories
    val selectedCategories = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Choose Your Preferences",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        categories.forEach { category ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .toggleable(
                        value = selectedCategories.contains(category),
                        onValueChange = {
                            if (it) selectedCategories.add(category)
                            else selectedCategories.remove(category)
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = selectedCategories.contains(category),
                    onCheckedChange = null // handled by Row toggleable
                )
                Text(text = category, modifier = Modifier.padding(start = 8.dp))
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            // Save preferences to Firestore (you could use Firebase Auth for per-user)
            val userPrefs = hashMapOf("preferences" to selectedCategories)
            db.collection("users").document("demoUser").set(userPrefs)

            // Navigate to HomeScreen
            navController.navigate("home") {
                popUpTo("preferences") { inclusive = true }
            }
        }) {
            Text("Save & Continue")
        }
    }
}
