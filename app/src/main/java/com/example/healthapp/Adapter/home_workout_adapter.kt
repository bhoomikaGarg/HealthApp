package com.example.healthapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.healthapp.R
import com.example.healthapp.model.Home_workout_list


class home_workout_adapter (val context: Context, val list: ArrayList<Home_workout_list>) : RecyclerView.Adapter<home_workout_adapter.homeWorkout_recycler>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): homeWorkout_recycler {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_workout_single_row, parent, false)

        return homeWorkout_recycler(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: homeWorkout_recycler, position: Int) {
        val homeExer = list[position]
        holder.heading.text = homeExer.heading
        //holder.image.setImageResource(Integer.parseInt(homeExer.image.toString()))
        Glide.with(holder.itemView.context).load(homeExer.image).into(holder.image)

        holder.linearLayoutHome.setOnClickListener {

        }
    }
    class homeWorkout_recycler(view: View) : RecyclerView.ViewHolder(view) {
        val heading: TextView = view.findViewById(R.id.heading_home)
        val image: ImageView = view.findViewById(R.id.home_img)
        val linearLayoutHome: LinearLayout = view.findViewById(R.id.linearLayoutHome)

    }
}

