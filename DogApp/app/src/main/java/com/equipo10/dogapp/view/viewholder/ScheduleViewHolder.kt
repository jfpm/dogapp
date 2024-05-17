package com.equipo10.dogapp.view.viewholder

import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.databinding.ItemScheduleBinding


class ScheduleViewHolder(binding: ItemScheduleBinding, navController: NavController) :
    RecyclerView.ViewHolder(binding.root){
    val bindingItem = binding
    val navController = navController

    fun setItemSchedule(schedule: Schedule){
        /*bindingItem.idName.text = schedule.name
        bindingItem.addRaza.text = schedule.race
        bindingItem.addNameOwner.text = schedule.name_owner
        bindingItem.addPhone.text = schedule.phone
        bindingItem.addSintoma.text = schedule.sysptoms

        bindingItem.btnGuardar.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("clave", schedule)
            navController.navigate(R.id.adminCitasFragment, bundle)
        }*/
    }
}