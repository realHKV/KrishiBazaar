package com.example.krishibazaar.location

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LocationViewModel: ViewModel(){
    private val _location = mutableStateOf<ModelLocationData?>(null)
    val location : State<ModelLocationData?> = _location

    fun updateLocation(newLocation:ModelLocationData){
        _location.value=newLocation
    }
}