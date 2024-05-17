package com.equipo10.dogapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.equipo10.dogapp.model.Appointment
import com.equipo10.dogapp.model.Schedule

@Dao
interface ScheduleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSchedule(schedule: Schedule)

    @Query("SELECT * FROM Schedule")
    suspend fun getListSchedule(): MutableList<Schedule>

    @Delete
    suspend fun deleteSchedule(schedule: Schedule)

    @Update
    suspend fun updateSchedule(schedule: Schedule)

    @Query("SELECT * FROM Schedule WHERE id = :scheduleId")
    suspend fun getScheduleById(scheduleId: Int): Schedule?

}