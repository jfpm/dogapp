package com.equipo10.dogapp.di

import android.content.Context
import com.equipo10.dogapp.data.ScheduleDB
import com.equipo10.dogapp.data.ScheduleDao
import com.equipo10.dogapp.utils.Constants.BASE_URL
import com.equipo10.dogapp.webservice.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideScheduleDB(@ApplicationContext context: Context): ScheduleDB{
        return ScheduleDB.getDatabase(context)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideDaoReto(scheduleDB: ScheduleDB):  ScheduleDao{
        return scheduleDB.scheduleDao()
    }


}