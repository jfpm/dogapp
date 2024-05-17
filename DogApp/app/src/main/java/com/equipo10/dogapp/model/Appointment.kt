package com.equipo10.dogapp.model

import com.google.gson.annotations.SerializedName

/*
* Modelo Cita
 * */
data class Appointment(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("race")
    val race: String,

    @SerializedName("name_owner")
    val name_owner: String,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("sysptoms")
    val sysptoms: Int
)
