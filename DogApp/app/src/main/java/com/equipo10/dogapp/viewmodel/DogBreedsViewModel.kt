package com.equipo10.dogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.equipo10.dogapp.di.Module
import com.equipo10.dogapp.model.DogBreedsResponse
import com.equipo10.dogapp.model.ImageDogResponse
import com.equipo10.dogapp.utils.Constants.BASE_URL
import com.equipo10.dogapp.webservice.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogBreedsViewModel : ViewModel() {
    //private val dogAPI = Module.provideRetrofit().create(ApiService::class.java)
    private val _breeds = MutableLiveData<List<String>>()
    val breeds: LiveData<List<String>> = _breeds

    private val _dogImageUrl = MutableLiveData<String>()
    val dogImageUrl: LiveData<String> = _dogImageUrl

    private val dogAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun fetchBreeds() {
        dogAPI.getBreeds().enqueue(object : Callback<DogBreedsResponse> {
            override fun onResponse(call: Call<DogBreedsResponse>, response: Response<DogBreedsResponse>) {
                if (response.isSuccessful) {
                    val breedsResponse = response.body()
                    val breedsMap = breedsResponse?.message ?: emptyMap()
                    val breedsList = breedsMap.keys.toList()
                    _breeds.value = breedsList
                }
            }

            override fun onFailure(call: Call<DogBreedsResponse>, t: Throwable) {
                // Maneja el fallo en la llamada a la API
            }
        })
    }

    fun fetchDogImageUrl(breed: String) {
        dogAPI.getRandomImage(breed).enqueue(object : Callback<ImageDogResponse> {
            override fun onResponse(call: Call<ImageDogResponse>, response: Response<ImageDogResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { imageResponse ->
                        val imageUrl = imageResponse.message
                        if (!imageUrl.isNullOrEmpty()) {
                            _dogImageUrl.value = imageUrl
                        } else {
                            // Manejar el caso en que la URL de la imagen esté vacía
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ImageDogResponse>, t: Throwable) {
                // Maneja el fallo en la llamada a la API
            }
        })

    }
}