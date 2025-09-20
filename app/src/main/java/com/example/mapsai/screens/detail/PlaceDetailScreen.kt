package com.example.mapsai.screens.detail

@Composable
fun PlaceDetailScreen(place: Place, onSave: (Place) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(place.name, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))
        Text(place.description, style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(16.dp))

        Button(onClick = { onSave(place) }) {
            Text("Save to Favorites")
        }
    }
}
