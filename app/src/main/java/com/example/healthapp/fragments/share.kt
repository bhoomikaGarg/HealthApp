package com.example.healthapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthapp.R


class share : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_share, container, false)

        val myIntent = Intent(Intent.ACTION_SEND)
        myIntent.type = "type/plain"
        val shareBody = "Your Body Here"
        val shareSub = "Your Subject Here"
        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody)
        myIntent.putExtra(Intent.EXTRA_TEXT, shareSub)
        startActivity(Intent.createChooser(myIntent,"Share Your App"))

        return view
    }

}