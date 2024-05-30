package com.equipo10.dogapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.equipo10.dogapp.model.Appointment
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.repository.ScheduleRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


class ScheduleViewModel(application: Application): AndroidViewModel(application) {

    val context = getApplication<Application>()
    private val scheduleRepository = ScheduleRepository(context)

    private val _listSchedule = MutableLiveData<MutableList<Schedule>>()
    val listSchedule: LiveData<MutableList<Schedule>> get() = _listSchedule

    private val _progresState = MutableLiveData(false)
    val progresState: LiveData<Boolean> = _progresState

    //almacenar las citas en la agenda
    private val _listAppointment = MutableLiveData<MutableList<Appointment>>()
    val listAppointment: LiveData<MutableList<Appointment>> = _listAppointment

    fun  saveSchedule(schedule: Schedule){
        viewModelScope.launch {
            _progresState.value = true
            try {
                scheduleRepository.saveSchedule(schedule)
                _progresState.value = false
            } catch (e: Exception){
                _progresState.value = false
            }
        }
    }


    fun getListSchedule(){
        viewModelScope.launch {
            _progresState.value = true
            try {
                _listSchedule.value = scheduleRepository.getListSchedule()
                _progresState.value = false
            }catch (e: Exception){
                _progresState.value = false
            }
        }
    }

    fun deleteSchedule(schedule: Schedule){
        viewModelScope.launch {
            _progresState.value = true
            try {
                scheduleRepository.deleteSchedule(schedule)
                _progresState.value = false
            }catch (e: Exception){
                _progresState.value = false
            }
        }
    }

    fun updateSchedule(schedule: Schedule){
        viewModelScope.launch {
            _progresState.value = true
            try {
                scheduleRepository.updateSchedule(schedule)
                _progresState.value = false
            } catch (e: Exception) {
                _progresState.value = false
            }
        }
    }


}