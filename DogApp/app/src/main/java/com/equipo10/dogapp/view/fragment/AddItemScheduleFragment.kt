package com.equipo10.dogapp.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.equipo10.dogapp.R
import com.equipo10.dogapp.databinding.FragmentAddItemScheduleBinding
import com.equipo10.dogapp.databinding.FragmentAdminCitasBinding
import com.equipo10.dogapp.model.Schedule
import com.equipo10.dogapp.viewmodel.ScheduleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddItemScheduleFragment : Fragment() {

    private lateinit var binding: FragmentAddItemScheduleBinding
    private val scheduleViewModel: ScheduleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_admin_citas, container, false)
        binding = FragmentAddItemScheduleBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAutoCompleteTextView()
        controladores()
        setupTextWatchers()
    }

    private fun setupAutoCompleteTextView() {
        val symptoms = resources.getStringArray(R.array.symptoms_array)
        Log.d("Info", symptoms.toString())
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, symptoms)
        binding.addSymptomsAutoComplete.setAdapter(adapter)
    }

    private fun controladores(){
        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.action_addItemScheduleFragment_to_adminCitasFragment3)
        }

        binding.btnSaveAppointment.setOnClickListener {
            saveSchedule()
        }
    }

    private fun setupTextWatchers() {
        val requiredFields = listOf(
            binding.addName,
            binding.addRaza,
            binding.addNameOwner,
            binding.addPhone,
            binding.addSymptomsAutoComplete
        )

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.btnSaveAppointment.isEnabled = requiredFields.all { it.text.isNotEmpty() }
            }
            override fun afterTextChanged(s: Editable?) {}
        }

        requiredFields.forEach { it.addTextChangedListener(textWatcher) }
    }

    private fun saveSchedule(){
        val name: String = binding.addName.text.toString()
        val race: String = binding.addRaza.text.toString()
        val name_owner: String = binding.addNameOwner.text.toString()
        val phone: String = binding.addPhone.text.toString()
        val sysptoms: String = binding.addSymptomsAutoComplete.text.toString()

        val schedule = Schedule(name = name, race = race, name_owner = name_owner, phone = phone,  sysptoms = sysptoms)
        scheduleViewModel.saveSchedule(schedule)

        Log.d("Agendar", schedule.toString())
        notifyUser("Cita agenda !!")
        findNavController().popBackStack()

    }

    private fun notifyUser(message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }



}