package com.example.superapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.superapp.databinding.ActivityLogInBinding
import kotlin.math.log

class LogInActivity : AppCompatActivity() {
    lateinit var logActivity: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logActivity = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(logActivity.root)

        logActivity.logName.text = R.string.welcome.toString() + "${intent.getStringExtra("myName").toString()}"

        logActivity.logOut.setOnClickListener {
            Toast.makeText(applicationContext, "Good Bye ${intent.getStringExtra("myName")}", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}