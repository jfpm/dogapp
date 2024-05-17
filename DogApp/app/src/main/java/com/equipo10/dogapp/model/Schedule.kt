package com.equipo10.dogapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Modelo agendar
* */
@Entity
data class Schedule(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,// 15 carac
    val race: String,//raza
    val name_owner: String,//propietario nombre 30 caracteres
    val phone: Int,//teléfono 10 carac
    val sysptoms: String, //Sintomas
)
