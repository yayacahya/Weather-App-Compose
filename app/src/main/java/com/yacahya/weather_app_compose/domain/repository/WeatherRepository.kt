package com.yacahya.weather_app_compose.domain.repository

import com.yacahya.weather_app_compose.domain.util.Resource
import com.yacahya.weather_app_compose.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}