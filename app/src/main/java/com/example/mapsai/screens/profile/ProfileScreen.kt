package com.example.mapsai.screens.profile

@Composable
fun ProfileScreen(
    userName: String,
    preferences: List<Preference>,
    onLogout: () -> Unit
) {
    Column(Modifier.padding(16.dp)) {
        Text("Welcome, $userName", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        Text("Your Preferences:")
        preferences.forEach { Text("• ${it.name}") }

        Spacer(Modifier.weight(1f))

        Button(onClick = onLogout, modifier = Modifier.fillMaxWidth()) {
            Text("Log Out")
        }
    }
}
