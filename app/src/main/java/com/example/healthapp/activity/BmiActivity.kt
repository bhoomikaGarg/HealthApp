package com.example.healthapp.activity

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.healthapp.R
import com.google.android.material.snackbar.Snackbar
import kotlin.properties.Delegates

class BmiActivity : AppCompatActivity() {
     lateinit var weight : EditText
     lateinit var height : EditText
    lateinit var btnBmi : Button
    lateinit var result : TextView
    lateinit var linking : TextView
    var heightValue by Delegates.notNull<Float>()
    var weightValue by Delegates.notNull<Float>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        linking=findViewById(R.id.linking)
        height = findViewById(R.id.Height)
        weight = findViewById(R.id.Weight)
        btnBmi = findViewById(R.id.btn_bmi)
        result = findViewById(R.id.txtResult)
        result.visibility = View.GONE

        linking.movementMethod = LinkMovementMethod.getInstance()


        btnBmi.setOnClickListener(
            View.OnClickListener
            {

                val bmiWeight = weight.text.toString().toInt()
                val bmiHeight = height.text.toString().toInt()
                val bmiCalc =  bmiWeight.toDouble() / bmiHeight / bmiHeight * 10000
                result.setVisibility(View.VISIBLE)
                val bmiInterpretation = interpretBMI(bmiCalc)
                result.text = "BMI VALUE: $bmiCalc"
                pop_box(bmiInterpretation)

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
    private fun pop_box(bmiInterpretation:String){
        val snackbar = Snackbar.make(
            findViewById(R.id.BmiActivity),
            "You are "+bmiInterpretation , Snackbar.LENGTH_INDEFINITE
        )
        snackbar.show()
        snackbar.setAction("OK", MyUndoListener())
    }
    class MyUndoListener : View.OnClickListener {
        override fun onClick(v: View) {}
    }

}