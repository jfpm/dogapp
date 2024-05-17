package com.equipo10.dogapp.repository

import com.equipo10.dogapp.data.ScheduleDao
import com.equipo10.dogapp.model.Appointment
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.webservice.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScheduleRepository @Inject  constructor(
    private val scheduleDao: ScheduleDao,
    private val apiService: ApiService
) {
    suspend fun  saveSchedule(schedule: Schedule){
        withContext(Dispatchers.IO){
            scheduleDao.saveSchedule(schedule)
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
}