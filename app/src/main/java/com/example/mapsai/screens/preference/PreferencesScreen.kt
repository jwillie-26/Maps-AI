package com.example.mapsai.screens.preference

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
import com.example.mapsai.screens.components.TopBar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun PreferencesScreen(navController: NavController) {
    val db = FirebaseFirestore.getInstance()
    val auth = FirebaseAuth.getInstance()
    val uid = auth.currentUser?.uid ?: "demoUser" // fallback for dev

    // Example categories
    val categories = listOf("Restaurants", "Parks", "Museums", "Cafes", "Hotels")
    val selectedCategories = remember { mutableStateListOf<String>() }
    var loading by remember { mutableStateOf(true) }

    // Load existing preferences on first composition
    LaunchedEffect(uid) {
        loading = true
        try {
            val doc = db.collection("users").document(uid).get().await()
            val prefs = doc.get("preferences") as? List<*>
            prefs?.forEach {
                val s = it as? String
                if (s != null && !selectedCategories.contains(s)) selectedCategories.add(s)
            }
        } catch (e: Exception) {
            // ignore; empty defaults ok
        } finally {
            loading = false
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(title = "Preferences")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Choose Your Preferences",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Spacer(Modifier.height(8.dp))

            // list of checkboxes
            categories.forEach { category ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .toggleable(
                            value = selectedCategories.contains(category),
                            onValueChange = {
                                if (it) selectedCategories.add(category) else selectedCategories.remove(category)
                            }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = selectedCategories.contains(category),
                        onCheckedChange = null
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(text = category)
                }
            }

            Spacer(Modifier.weight(1f))

            Button(onClick = {
                // Save preferences to Firestore (async on IO)
                CoroutineScope(Dispatchers.IO).launch {
                    db.collection("users").document(uid).set(mapOf("preferences" to selectedCategories))
                }
                // navigate to home (clear backstack)
                navController.navigate("home") { popUpTo("preferences") { inclusive = true } }
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Save & Continue")
            }
        }
    }
}
