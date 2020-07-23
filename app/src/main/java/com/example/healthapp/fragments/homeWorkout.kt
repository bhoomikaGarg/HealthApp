package com.example.healthapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.healthapp.Adapter.home_workout_adapter
import com.example.healthapp.R
import com.example.healthapp.model.Home_workout_list


class homeWorkout : Fragment() {
    lateinit var recyclerView : RecyclerView
    lateinit var layoutManager_home : RecyclerView.LayoutManager
    lateinit var recyclerAdapter:home_workout_adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_home_workout, container, false)
        recyclerView = view.findViewById(R.id.home_workout_recycler)
        layoutManager_home = LinearLayoutManager(activity)
        val workout_list = arrayListOf<Home_workout_list>()

        workout_list.add(
                Home_workout_list("PRESS UP", R.drawable.press_up)
        )
        workout_list.add(
            Home_workout_list("SKIPPING", R.drawable.skipping)
        )
        workout_list.add(
            Home_workout_list("BURPEES", R.drawable.burpee)
        )
        workout_list.add(
            Home_workout_list("JUMPING LUNGES", (R.drawable.jumping_lunges))
        )
        workout_list.add(
                Home_workout_list("Spiderman Press-Up", (R.drawable.spiderman_pressup))
                )
        workout_list.add(
            Home_workout_list("PLANK",(R.drawable.plank))
        )
        workout_list.add(
            Home_workout_list("DEADBUG", (R.drawable.deadbug))
        )
        workout_list.add(
            Home_workout_list("CRUNCHES", (R.drawable.crunches))
        )
        workout_list.add(
            Home_workout_list("BACK EXTENSION", (R.drawable.pronebackextension))
        )
        workout_list.add(
            Home_workout_list("SHADOW BOXING", (R.drawable.shadowbox))
        )


        recyclerAdapter = home_workout_adapter(activity as Context,workout_list)
        recyclerView.layoutManager = layoutManager_home
        recyclerView.adapter = recyclerAdapter

        return view
    }


}