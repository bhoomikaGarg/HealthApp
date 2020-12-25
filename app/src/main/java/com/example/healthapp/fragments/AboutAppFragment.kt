package com.example.healthapp.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.healthapp.R
import com.example.healthapp.activity.developedBy


class AboutAppFragment : Fragment() {
    lateinit var mTextField:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_about_app, container, false)

        mTextField= view.findViewById(R.id.extra) as TextView


        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                mTextField.setText("done!")

            }
        }.start()
        return view
    }


}