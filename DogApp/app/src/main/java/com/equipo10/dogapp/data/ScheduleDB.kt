package com.equipo10.dogapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.utils.Constants.NAME_BD

@Database(entities = [Schedule::class], version = 1)
abstract class ScheduleDB : RoomDatabase() {

    abstract  fun scheduleDao(): ScheduleDao

    companion object{
        fun getDatabase(context: Context): ScheduleDB {
            return Room.databaseBuilder(
                context.applicationContext,
                ScheduleDB::class.java,
                NAME_BD
            ).build()
        }
    }
}