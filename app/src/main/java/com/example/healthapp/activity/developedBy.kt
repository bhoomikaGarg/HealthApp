package com.example.healthapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.TextView
import com.example.healthapp.R

class developedBy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developed_by)

        val feedback: TextView = findViewById(R.id.feedback)
        feedback.text =
            Html.fromHtml("<a href=\"mailto:bhoomika.garg.9@gmail.com\">Send Feedback</a>")
        feedback.movementMethod = LinkMovementMethod.getInstance()

        val feedback1: TextView = findViewById(R.id.feedback1)
        feedback1.text =
            Html.fromHtml("<a href=\"mailto:bhoomika.garg.9@gmail.com\">Send Feedback</a>")
        feedback1.movementMethod = LinkMovementMethod.getInstance()

    }

}