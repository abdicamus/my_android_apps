package com.example.toolbarmenuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toolbarmenuapp.databinding.ActivityAgeBinding

class AgeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ageButton.setOnClickListener {
            val intent = Intent().putExtra("age", binding.editAge.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}