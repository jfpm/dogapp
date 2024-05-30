package com.equipo10.dogapp.view.viewholder

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.equipo10.dogapp.R
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.databinding.ItemScheduleBinding
import com.equipo10.dogapp.viewmodel.DogBreedsViewModel


class ScheduleViewHolder(binding: ItemScheduleBinding, navController: NavController) :
    RecyclerView.ViewHolder(binding.root){
    val bindingItem = binding
    val navController = navController

    fun setItemSchedule(schedule: Schedule){
        bindingItem.tvName.text = schedule.name
        bindingItem.tvId.append(schedule.id.toString())
        bindingItem.tvSymptom.text = schedule.sysptoms

        //DogBreedsViewModel.fetchDogImageUrl(schedule.race)
        bindingItem.viewSchedule.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("clave", schedule.toString())
            navController.navigate(R.id.action_adminCitasFragment_to_itemDetailsSchuleFragment, bundle)
        }
    }

    fun setDogImage(imageUrl: String?) {
        println("imagen$imageUrl")
        // Cargar la imagen del perro utilizando una biblioteca como Glide o Picasso
        Glide.with(bindingItem.root.context)
            .load(imageUrl)
            .into(bindingItem.ivPetImage)
    }

}