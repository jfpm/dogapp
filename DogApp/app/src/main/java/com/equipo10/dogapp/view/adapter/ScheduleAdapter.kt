package com.equipo10.dogapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.equipo10.dogapp.databinding.ItemScheduleBinding
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.view.viewholder.ScheduleViewHolder

class ScheduleAdapter(private val listSchedule: MutableList<Schedule>, private val navController: NavController): RecyclerView.Adapter<ScheduleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding: ItemScheduleBinding = ItemScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleViewHolder(binding, navController)
    }

    override fun getItemCount(): Int {
        return listSchedule.size
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val schedule: Schedule = listSchedule[position]
        holder.setItemSchedule(schedule)
    }

}