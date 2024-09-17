package com.example.krishibazaar.Presentation.weather.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.krishibazaar.Presentation.weather.api.Constant
import com.example.krishibazaar.Presentation.weather.api.NetworkResponse
import com.example.krishibazaar.Presentation.weather.api.RetrofitInstance
import com.example.krishibazaar.Presentation.weather.api.WeatherModel
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException
import kotlinx.coroutines.launch
import java.io.IOException

class WeatherViewModel : ViewModel() {
    private val weatherApi = RetrofitInstance.weatherApi
    private val _weatherResult= MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult: LiveData<NetworkResponse<WeatherModel>> = _weatherResult

    fun getData(city: String) {
        _weatherResult.value= NetworkResponse.Loading

        viewModelScope.launch {
            viewModelScope.launch {
                try {
                    val response = weatherApi.getWeather(Constant.apiKey, city)

                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body != null) {
                            _weatherResult.value = NetworkResponse.Success(body)
                        } else {
                            _weatherResult.value = NetworkResponse.Error("No data found for the city")
                        }
                    } else {
                        _weatherResult.value = NetworkResponse.Error("Error: ${response.code()} - ${response.message()}")
                    }

                } catch (e: IOException) {
                    _weatherResult.value = NetworkResponse.Error("Network error: ${e.localizedMessage}")
                } catch (e: HttpException) {
                    _weatherResult.value = NetworkResponse.Error("Server error: ${e.localizedMessage}")
                } catch (e: Exception) {
                    _weatherResult.value = NetworkResponse.Error("Unexpected error: ${e.localizedMessage}")
                }
            }


        }
    }
}