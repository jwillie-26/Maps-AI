package com.example.mapsai.screens.home

@Composable
fun HomeScreen(

    places: List<Place>,
    onPlaceClick: (Place) -> Unit
) {
    Column {
        Text(
            "Recommended for You",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {
            items(places) { place ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onPlaceClick(place) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(place.name, style = MaterialTheme.typography.titleMedium)
                        Text(place.description, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
