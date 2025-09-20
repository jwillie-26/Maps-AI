package com.example.mapsai.screens.onboarding

@Composable
fun OnboardingScreen(
    preferences: List<Preference>,
    onPreferenceSelected: (Preference) -> Unit,
    onContinue: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Choose your interests", style = MaterialTheme.typography.headlineMedium)

        LazyColumn {
            items(preferences) { pref ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onPreferenceSelected(pref) }
                        .padding(12.dp)
                ) {
                    Checkbox(
                        checked = pref.selected,
                        onCheckedChange = { onPreferenceSelected(pref) }
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(pref.name, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }

        Spacer(Modifier.weight(1f))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onContinue
        ) {
            Text("Continue")
        }
    }
}
