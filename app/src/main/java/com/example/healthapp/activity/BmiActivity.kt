package com.example.healthapp.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.healthapp.R
import kotlinx.android.synthetic.main.activity_bmi.*

class BmiActivity : AppCompatActivity() {
    lateinit var weight : EditText
    lateinit var height : EditText
    lateinit var btnBmi : Button
    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

// Get the references to the widgets
        height = findViewById(R.id.Height)
        weight = findViewById(R.id.Weight)
        btnBmi = findViewById(R.id.btn_bmi)
        result = findViewById(R.id.txtResult)

        btnBmi.setOnClickListener(
            View.OnClickListener
            // Logic for validation, input can't be empty
            {
                val str1 = weight.text.toString()
                val str2 = height.text.toString()
                if (TextUtils.isEmpty(str1)) {
                    weight.error = "Please enter your weight"
                    weight.requestFocus()
                    return@OnClickListener
                }
                if (TextUtils.isEmpty(str2)) {
                    height.error = "Please enter your height"
                    height.requestFocus()
                    return@OnClickListener
                }

                //Get the user values from the widget reference
                val weight = str1.toFloat()
                val height = str2.toFloat() / 100

                //Calculate BMI value
                val bmiValue = calculateBMI(weight, height)

                //Define the meaning of the bmi value
                val bmiInterpretation = interpretBMI(bmiValue)
                result.text = "$bmiValue-$bmiInterpretation"
            })
    }

    //Calculate BMI
    private fun calculateBMI(weight: Float, height: Float): Float {
        return (weight / (height * height))
    }

    // Interpret what BMI means
    private fun interpretBMI(bmiValue: Float): String {
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