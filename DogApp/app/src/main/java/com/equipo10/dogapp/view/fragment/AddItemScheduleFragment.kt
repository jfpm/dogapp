package com.equipo10.dogapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.equipo10.dogapp.R



/**
 * A simple [Fragment] subclass.
 * Use the [AddItemScheduleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddItemScheduleFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item_schedule, container, false)
    }


}