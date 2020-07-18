package com.example.healthapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.healthapp.R
import com.example.healthapp.activity.*


class DimensionOfWellnessFragment : Fragment() {

    lateinit var physical : CardView
    lateinit var social : CardView
    lateinit var emotional : CardView
    lateinit var spiritual : CardView
    lateinit var intellectual : CardView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dimension_of_wellness, container, false)

        physical = view.findViewById(R.id.physical)
        social = view.findViewById(R.id.social)
        emotional = view.findViewById(R.id.emotional)
        spiritual = view.findViewById(R.id.spiritual)
        intellectual = view.findViewById(R.id.intellectual)

        physical.setOnClickListener {
            val intent = Intent(context, PhysicalActivity::class.java)
            startActivity(intent)
        }
        social.setOnClickListener {
            val intent = Intent(context, SocialActivity::class.java)
            startActivity(intent)
        }
        emotional.setOnClickListener {
            val intent = Intent(context, EmotionalActivity::class.java)
            startActivity(intent)
        }
        spiritual.setOnClickListener {
            val intent = Intent(context, SpiritualActivity::class.java)
            startActivity(intent)
        }
        intellectual.setOnClickListener {
            val intent = Intent(context, IntellectualActivity::class.java)
            startActivity(intent)
        }
        return  view
    }


}