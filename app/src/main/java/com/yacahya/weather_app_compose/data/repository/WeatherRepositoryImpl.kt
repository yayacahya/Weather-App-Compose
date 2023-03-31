package com.yacahya.weather_app_compose.data.repository

import com.yacahya.weather_app_compose.data.mappers.toWeatherInfo
import com.yacahya.weather_app_compose.data.remote.WeatherApi
import com.yacahya.weather_app_compose.domain.repository.WeatherRepository
import com.yacahya.weather_app_compose.domain.util.Resource
import com.yacahya.weather_app_compose.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}