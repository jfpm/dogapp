package com.equipo10.dogapp.repository

import android.content.Context
import android.util.Log
import com.equipo10.dogapp.data.ScheduleDB
import com.equipo10.dogapp.data.ScheduleDao
import com.equipo10.dogapp.model.Appointment
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.webservice.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScheduleRepository (val context: Context) {

    private var scheduleDao : ScheduleDao = ScheduleDB.getDatabase(context).scheduleDao()
    suspend fun  saveSchedule(schedule: Schedule){
        // Verifica si la información del schedule no es nula y si cumple con ciertas condiciones antes de guardarlo
        if (schedule.name.isNotEmpty() && schedule.race.isNotEmpty() && schedule.name_owner.isNotEmpty() && schedule.phone.isNotEmpty() && schedule.sysptoms.isNotEmpty()) {
            withContext(Dispatchers.IO) {
                scheduleDao.saveSchedule(schedule)
            }
            // Aquí puedes agregar un registro de éxito al registro de logs
            Log.d("Repository", "Schedule saved successfully: $schedule")
        } else {
            // Aquí puedes manejar el caso en el que la información del schedule no sea válida
            Log.e("Repository", "Invalid schedule information: $schedule")
            throw IllegalArgumentException("Invalid schedule information")
        }
    }

    suspend fun getListSchedule(): MutableList<Schedule>{
        return withContext(Dispatchers.IO){
            scheduleDao.getListSchedule()
        }
    }

    suspend fun deleteSchedule(schedule: Schedule){
        withContext(Dispatchers.IO){
            scheduleDao.deleteSchedule(schedule)
        }
    }

    suspend fun updateSchedule(schedule: Schedule){
        withContext(Dispatchers.IO){
            scheduleDao.updateSchedule(schedule)
        }
    }

    suspend fun getScheduleById(scheduleId: Int): Schedule? {
        return scheduleDao.getScheduleById(scheduleId)
    }
}