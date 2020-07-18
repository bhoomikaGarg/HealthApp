package com.example.healthapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.healthapp.R
import com.example.healthapp.activity.BmiActivity
import com.example.healthapp.activity.StepCounter
import com.example.healthapp.activity.developedBy

class HomeFragment : Fragment() {

    lateinit var btnStepcounter : CardView
    lateinit var btnBMI : CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setHasOptionsMenu(true)
        btnStepcounter = view.findViewById(R.id.btnStepCounter)
        btnBMI = view.findViewById(R.id.btnBMI)

        btnStepcounter.setOnClickListener {
            val intent = Intent(context, StepCounter::class.java)
            startActivity(intent)
        }
        btnBMI.setOnClickListener {
            val intent = Intent(context, BmiActivity::class.java)
            startActivity(intent)
        }
        return view
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_information,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.info){
            val intent = Intent(context, developedBy::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}