package com.dandy.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var addButton:Button
    lateinit var subButton:Button
    lateinit var divButton:Button
    lateinit var prodButton:Button
    lateinit var firstInput:EditText
    lateinit var secondInput:EditText
    lateinit var answerView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        addButton = findViewById(R.id.addButton)
        subButton = findViewById(R.id.subButton)
        divButton = findViewById(R.id.divButton)
        prodButton = findViewById(R.id.prodButton)
        answerView = findViewById(R.id.answerView)
        firstInput = findViewById(R.id.firstInput)
        secondInput = findViewById(R.id.secondInput)


        addButton!!.setOnClickListener {
            var firstnumber = firstInput.text.toString()
            var secondnumber = secondInput.text.toString()
            if (firstnumber.isEmpty() || secondnumber.isEmpty()) {
                answerView.text = "Please fill all inputs"
            } else {
                var answer = firstnumber.toDouble() + secondnumber.toDouble()
                answerView.text = answer.toString()
            }
        }

        subButton!!.setOnClickListener {
            var firstnumber = firstInput.text.toString()
            var secondnumber = secondInput.text.toString()
            if (firstnumber.isEmpty() || secondnumber.isEmpty()) {
                answerView.text = "Please fill all inputs"
            } else {
                var answer = firstnumber.toDouble() - secondnumber.toDouble()
                answerView.text = answer.toString()
            }
        }

        divButton!!.setOnClickListener {
            var firstnumber = firstInput.text.toString()
            var secondnumber = secondInput.text.toString()
            if (firstnumber.isEmpty() || secondnumber.isEmpty()) {
                answerView.text = "Please fill all inputs"
            } else {
                var answer = firstnumber.toDouble() / secondnumber.toDouble()
                answerView.text = answer.toString()
            }
        }

        prodButton!!.setOnClickListener {
            var firstnumber = firstInput.text.toString()
            var secondnumber = secondInput.text.toString()
            if (firstnumber.isEmpty() || secondnumber.isEmpty()) {
                answerView.text = "Please fill all inputs"
            } else {
                var answer = firstnumber.toDouble() * secondnumber.toDouble()
                answerView.text = answer.toString()
            }
        }
    }
}