package com.equipo10.dogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.equipo10.dogapp.model.Appointment
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.repository.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel  @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) : ViewModel() {

    private val _listSchedule = MutableLiveData<MutableList<Schedule>>()
    val listSchedule: LiveData<MutableList<Schedule>> get() = _listSchedule

    private val _progresSate = MutableLiveData(false)
    val progresState: LiveData<Boolean> = _progresSate

    //almacenar las citas en la agenda
    private val _listAppointment = MutableLiveData<MutableList<Appointment>>()
    val listAppointment: LiveData<MutableList<Appointment>> = _listAppointment

    fun  saveSchedule(schedule: Schedule){
        viewModelScope.launch {
            _progresSate.value = true
            try {
                scheduleRepository.saveSchedule(schedule)
                _progresSate.value = false
            } catch (e: Exception){
                _progresSate.value = false
            }
        }
    }


    fun getListSchedule(){
        viewModelScope.launch {
            _progresSate.value = true
            try {
                scheduleRepository.getListSchedule()
                _progresSate.value = false
            }catch (e: Exception){
                _progresSate.value = false
            }
        }
    }

    fun deleteSchedule(schedule: Schedule){
        viewModelScope.launch {
            _progresSate.value = true
            try {
                scheduleRepository.deleteSchedule(schedule)
                _progresSate.value = false
            }catch (e: Exception){
                _progresSate.value = false
            }
        }
    }

    fun updateSchedule(schedule: Schedule){
        viewModelScope.launch {
            _progresSate.value = true
            try {
                scheduleRepository.updateSchedule(schedule)
                _progresSate.value = false
            } catch (e: Exception) {
                _progresSate.value = false
            }
        }
    }


}