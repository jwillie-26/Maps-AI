package com.example.mapsai.data.model

data class Place(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val lat: Double = 0.0,
    val lng: Double = 0.0,
    val imageUrl: String = "",
    val category: String = ""
)