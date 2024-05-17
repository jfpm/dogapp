package com.equipo10.dogapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.equipo10.dogapp.R
import com.equipo10.dogapp.databinding.FragmentAdminCitasBinding
import com.equipo10.dogapp.view.adapter.ScheduleAdapter
import com.equipo10.dogapp.viewmodel.ScheduleViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [AdminCitasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdminCitasFragment : Fragment() {

    private lateinit var binding: FragmentAdminCitasBinding
    private val scheduleViewModel: ScheduleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_admin_citas, container, false)
        binding = FragmentAdminCitasBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
        observadorViewmodel()
    }

    private fun controladores(){
        binding.btnagendarcita.setOnClickListener {
            findNavController().navigate(R.id.action_adminCitasFragment_to_addItemSchedule)
        }
    }

    private fun observadorViewmodel(){

    }

    private fun observerListSchedule(){
        scheduleViewModel.getListSchedule()
        scheduleViewModel.listSchedule.observe(viewLifecycleOwner){listSchedule ->
            val recycler: RecyclerView = binding.recyclerview
            val layoutManager =  LinearLayoutManager(context)
            recycler.layoutManager = layoutManager
            val adapter = ScheduleAdapter(listSchedule, findNavController())
            recycler.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }


    private fun observerProgress(){
        scheduleViewModel.progresState.observe(viewLifecycleOwner){status ->
            binding.progress.isVisible = status
        }
    }


}