package com.dandy.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var buttonCalc:Button ?=null
    var buttonIntent:Button ?=null
    var buttonWeb:Button ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalc=findViewById(R.id.buttonCalc)
        buttonIntent=findViewById(R.id.buttonIntent)
        buttonWeb=findViewById(R.id.buttonWeb)

        buttonCalc!!.setOnClickListener {
            val intent=Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
        buttonIntent!!.setOnClickListener {
            val intent=Intent(this, IntentActivity::class.java)
            startActivity(intent)
        }
        buttonWeb!!.setOnClickListener {
            val intent=Intent(this, WebActivity::class.java)
            startActivity(intent)
        }
    }
}