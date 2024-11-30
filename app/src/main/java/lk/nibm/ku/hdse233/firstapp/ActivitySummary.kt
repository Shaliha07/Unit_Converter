package lk.nibm.ku.hdse233.firstapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivitySummary : AppCompatActivity() {

    private lateinit var results: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_summary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        results = findViewById(R.id.results)
        val intent:Intent=getIntent()

        val conversionType = intent.getStringExtra("conversionType")
        val conversionResult = intent.getDoubleExtra("conversionResult", 0.0)

        results.text = "Conversion: $conversionType\nResult: $conversionResult"
    }
}