package com.example.mapsai.viewmodel

import androidx.lifecycle.*
import com.example.mapsai.data.model.Place
import com.example.mapsai.data.repository.PlacesRepository
import com.example.mapsai.data.repository.UserRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val userRepo: UserRepository = UserRepository(),
    private val placesRepo: PlacesRepository = PlacesRepository()
) : ViewModel() {

    private val _places = MutableLiveData<List<Place>>()
    val places: LiveData<List<Place>> = _places

    fun loadRecommendedPlaces() {
        viewModelScope.launch {
            val prefs = userRepo.getPreferences()
            val recommended = placesRepo.getPlacesByPreferences(prefs)
            _places.value = recommended
        }
    }

    fun saveFavorite(place: Place) {
        viewModelScope.launch {
            userRepo.saveFavorite(place)
        }
    }
}
