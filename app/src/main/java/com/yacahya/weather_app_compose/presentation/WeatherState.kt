package com.yacahya.weather_app_compose.presentation

import com.yacahya.weather_app_compose.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)