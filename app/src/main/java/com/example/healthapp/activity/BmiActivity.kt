package com.example.healthapp.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.healthapp.R

class BmiActivity : AppCompatActivity() {
     lateinit var weight : EditText
     lateinit var height : EditText
    lateinit var btnBmi : Button
    lateinit var result : TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

// Get the references to the widgets
        height = findViewById(R.id.Height)
        weight = findViewById(R.id.Weight)
        btnBmi = findViewById(R.id.btn_bmi)
        result = findViewById(R.id.txtResult)
        result.setVisibility(View.GONE)

        val str1 = weight.text.toString()
        val str2 = height.text.toString()
        btnBmi.setOnClickListener(
            View.OnClickListener
            {

                val bmiWeight = weight.text.toString().toInt()
                val bmiHeight = height.text.toString().toInt()
                val bmiCalc =  bmiWeight.toDouble() / bmiHeight / bmiHeight * 10000
               // result.text = bmiCalc.toString()
                result.setVisibility(View.VISIBLE)
                val bmiInterpretation = interpretBMI(bmiCalc)
               result.text = "BMI VALUE: $bmiCalc \n You're $bmiInterpretation"

//                if (TextUtils.isEmpty(str1)) {
//                    weight.error = "Please enter your weight"
//                    weight.requestFocus()
//                    return@OnClickListener
//                }
//                if (TextUtils.isEmpty(str2)) {
//                    height.error = "Please enter your height"
//                    height.requestFocus()
//                    return@OnClickListener
//                }
//
//                //Get the user values from the widget reference
//                val weight = str1.toFloat()
//                val height = str2.toFloat() / 100
//
//                //Calculate BMI value
//                val bmiValue = calculateBMI(weight, height)
//
//                //Define the meaning of the bmi value
//                val bmiInterpretation = interpretBMI(bmiValue)
//                result.text = "BMI VALUE: "+bmiValue +" so it's "+bmiInterpretation;
//                Toast.makeText(applicationContext, "BMI CALCULATION", Toast.LENGTH_LONG)
//                    .show()

            })
    }


    // Interpret what BMI means
    private fun interpretBMI(bmiValue: Double): String {
        return if (bmiValue < 16) {
            "Severely underweight"
        } else if (bmiValue < 18.5) {
            "Underweight"
        } else if (bmiValue < 25) {
            "Normal"
        } else if (bmiValue < 30) {
            "Overweight"
        } else {
            "Obese"
        }
    }
}