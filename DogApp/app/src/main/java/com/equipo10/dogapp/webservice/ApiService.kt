package com.equipo10.dogapp.webservice

import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.utils.Constants.END_POINT
import retrofit2.http.GET

interface ApiService {

    @GET(END_POINT)
    suspend fun getSchedule(): MutableList<Schedule>
}