package com.example.mapsai.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    userName: String,
    preferences: List<String>,   // ✅ use String list instead of Preference
    onLogout: () -> Unit
) {
    Column(Modifier.padding(16.dp)) {
        Text(
            text = "Welcome, $userName",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(16.dp))

        Text("Your Preferences:")
        preferences.forEach { pref ->
            Text("• $pref")
        }

        Spacer(Modifier.weight(1f))

        Button(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Log Out")
        }
    }
}
