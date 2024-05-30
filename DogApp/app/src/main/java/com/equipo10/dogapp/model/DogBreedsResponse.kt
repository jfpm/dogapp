package com.equipo10.dogapp.model
import com.google.gson.annotations.SerializedName
data class DogBreedsResponse (
    @SerializedName("message")
    val message: Map<String, List<String>>,
    @SerializedName("status")
    val status: String
)