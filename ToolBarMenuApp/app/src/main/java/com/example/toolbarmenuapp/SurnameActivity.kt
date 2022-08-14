package com.example.toolbarmenuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toolbarmenuapp.databinding.ActivitySurnameBinding

class SurnameActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySurnameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurnameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.surnameButton.setOnClickListener {
            val intent = Intent().putExtra("surname", binding.editSurname.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}