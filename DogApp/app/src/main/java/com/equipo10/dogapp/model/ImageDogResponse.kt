package com.equipo10.dogapp.model

import com.google.gson.annotations.SerializedName

data class ImageDogResponse (
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)