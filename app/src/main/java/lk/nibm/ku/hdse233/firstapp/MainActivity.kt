package com.example.unitconverter

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import lk.nibm.ku.hdse233.firstapp.ActivitySummary
import lk.nibm.ku.hdse233.firstapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var value: EditText
    private lateinit var btncal: Button
    private lateinit var unit: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        value = findViewById(R.id.value)
        btncal = findViewById(R.id.btncal)
        unit = findViewById(R.id.unit)

        btncal.setOnClickListener {
            val input = value.text.toString().toDoubleOrNull()
            if (input == null) {
                value.error = "Please enter a valid number"
                return@setOnClickListener
            }

            val selectedConversion = unit.selectedItem.toString()
            val result = when (selectedConversion) {
                "Kilometers to Meters" -> input * 1000
                "Fahrenheit to Celsius" -> (input - 32) * 5 / 9
                "Grams to Kilograms" -> input / 1000
                else -> 0.0
            }

            val intent = Intent(this, ActivitySummary::class.java)
            intent.putExtra("conversionResult", result)
            intent.putExtra("conversionType", selectedConversion)
            startActivity(intent)
        }
    }
}
