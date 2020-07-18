package com.example.healthapp.Adapter

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healthapp.R
import com.example.healthapp.activity.gymActivity.*
import com.example.healthapp.model.gym_routine

class gym_beginner_adapter(val context: Context, val list: ArrayList<gym_routine>) : RecyclerView.Adapter<gym_beginner_adapter.gym_recycler>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): gym_recycler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gym_workout_routine_single_row,parent,false)

        return gym_recycler(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: gym_recycler, position: Int) {
        val gym= list[position]
        holder.gymday.text= gym.day
        holder.exercise.text= gym.exercise
        holder.gymparts.text= gym.bodyparts
        holder.linearLayoutgym.setOnClickListener {
            if(position==0){
                val i = Intent(context, Gym_Activity_beginner_day1::class.java)
                context.startActivity(i)
            }
            if(position==1){
                val i = Intent(context, Gym_Activity_beginner_day2::class.java)
                context.startActivity(i)
            }
            if(position==2){
                val i = Intent(context, Gym_Activity_beginner_day3::class.java)
                context.startActivity(i)
            }

        }
    }

    class gym_recycler(view: View): RecyclerView.ViewHolder(view) {
        val gymday : TextView =view.findViewById(R.id.gym_day);
        val exercise : TextView =view.findViewById(R.id.gym_exercise);
        val gymparts: TextView =view.findViewById(R.id.gym_bodyparts);
        val linearLayoutgym: LinearLayout = view.findViewById(R.id.llGym)

    }

}