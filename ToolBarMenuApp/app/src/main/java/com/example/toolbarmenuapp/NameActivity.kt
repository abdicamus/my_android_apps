package com.example.toolbarmenuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toolbarmenuapp.databinding.ActivityNameBinding

class NameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nameButton.setOnClickListener {
            val intent = Intent().putExtra("name", binding.editName.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}