package com.equipo10.dogapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.equipo10.dogapp.databinding.ItemScheduleBinding
import com.equipo10.dogapp.model.ImageDogResponse
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.utils.Constants
import com.equipo10.dogapp.view.viewholder.ScheduleViewHolder
import com.equipo10.dogapp.viewmodel.DogBreedsViewModel
import com.equipo10.dogapp.webservice.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ScheduleAdapter(private val listSchedule: MutableList<Schedule>,
                      private val navController: NavController
): RecyclerView.Adapter<ScheduleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemScheduleBinding = ItemScheduleBinding.inflate(inflater, parent, false)
        return ScheduleViewHolder(binding, navController)
    }

    override fun getItemCount(): Int {
        return listSchedule.size
    }


    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val schedule: Schedule = listSchedule[position]

        fetchDogImageUrl(schedule.race) { imageUrl ->
            holder.setDogImage(imageUrl)
            holder.setItemSchedule(schedule)
        }
    }

    private val dogAPI = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
    // Método para obtener la URL de la imagen del perro para un elemento específico en la lista
    private fun fetchDogImageUrl(breed: String, callback: (String) -> Unit) {
        dogAPI.getRandomImage(breed).enqueue(object : Callback<ImageDogResponse> {
            override fun onResponse(call: Call<ImageDogResponse>, response: Response<ImageDogResponse>) {
                if (response.isSuccessful) {
                    val imageUrl = response.body()?.message
                    if (!imageUrl.isNullOrEmpty()) {
                        callback(imageUrl)
                    } else {
                        // Manejar el caso en que la URL de la imagen esté vacía
                    }
                }
            }

            override fun onFailure(call: Call<ImageDogResponse>, t: Throwable) {
                // Maneja el fallo en la llamada a la API
            }
        })
    }
}