package com.example.mapsai.screens.home

import androidx.compose.foundation.layout.* // <-- for Column, Spacer, padding, etc.
import androidx.compose.material3.* // <-- for Button, Text, Material3 components
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier // <-- FIX for Modifier
import androidx.compose.ui.unit.dp // <-- FIX for dp values

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { navController.navigate("profile") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Profile Screen")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate(
                    "placeDetail/SamplePlace/This is a test description"
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Place Detail Screen")
        }
    }
}
