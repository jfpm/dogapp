package com.equipo10.dogapp.webservice

import com.equipo10.dogapp.model.DogBreedsResponse
import com.equipo10.dogapp.model.ImageDogResponse
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.utils.Constants.END_POINT
import com.equipo10.dogapp.utils.Constants.IMAGE_POINT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(END_POINT)
    fun getBreeds(): Call<DogBreedsResponse>

    @GET(IMAGE_POINT)
    fun getRandomImage(@Path("breed") breed: String): Call<ImageDogResponse>
}