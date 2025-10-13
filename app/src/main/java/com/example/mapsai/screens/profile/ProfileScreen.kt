package com.example.mapsai.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
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
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@Composable
fun ProfileScreen(
    navController: NavController
) {
    val db = FirebaseFirestore.getInstance()
    val auth = FirebaseAuth.getInstance()
    val uid = auth.currentUser?.uid ?: "demoUser"

    var userName by remember { mutableStateOf(auth.currentUser?.displayName ?: "Guest") }
    var prefs by remember { mutableStateOf(listOf<String>()) }
    val scope = rememberCoroutineScope()
    var loading by remember { mutableStateOf(true) }

    LaunchedEffect(uid) {
        loading = true
        try {
            val doc = db.collection("users").document(uid).get().await()
            val stored = doc.get("preferences") as? List<*>
            prefs = stored?.mapNotNull { it as? String } ?: emptyList()
            // optional: load display name from auth
            userName = auth.currentUser?.displayName ?: userName
        } catch (e: Exception) {
            prefs = emptyList()
        } finally {
            loading = false
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(title = "Profile")

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Welcome, $userName", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Your Preferences:", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            prefs.forEach { pref ->
                Text("• $pref", modifier = Modifier.padding(vertical = 4.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(onClick = {
                // optional: sign out
                scope.launch {
                    FirebaseAuth.getInstance().signOut()
                    navController.navigate("preferences") { popUpTo(0) }
                }
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Log Out")
            }
        }
    }
}
