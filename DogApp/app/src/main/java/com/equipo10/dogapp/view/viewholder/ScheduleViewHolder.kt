package com.equipo10.dogapp.view.viewholder

import android.os.Bundle
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.equipo10.dogapp.R
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.databinding.ItemScheduleBinding


class ScheduleViewHolder(binding: ItemScheduleBinding, navController: NavController) :
    RecyclerView.ViewHolder(binding.root){
    val bindingItem = binding
    val navController = navController

    fun setItemSchedule(schedule: Schedule){
        bindingItem.tvName.text = schedule.name
        bindingItem.tvId.text = schedule.id.toString()
        bindingItem.tvSymptom.text = schedule.sysptoms

        //bindingItem.addRaza.text = schedule.race
        ///bindingItem.tvNameOwner.text = schedule.name_owner
        //bindingItem.tvPhone.text = schedule.phone

        bindingItem.viewSchedule.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("clave", schedule.toString())
            navController.navigate(R.id.action_adminCitasFragment_to_itemDetailsSchuleFragment, bundle)
        }
    }
}