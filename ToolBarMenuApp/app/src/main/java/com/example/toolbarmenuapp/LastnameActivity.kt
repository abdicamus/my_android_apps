package com.example.toolbarmenuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toolbarmenuapp.databinding.ActivityLastnameBinding

class LastnameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLastnameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLastnameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lastnameButton.setOnClickListener {
            val intent = Intent().putExtra("lastname", binding.editLastname.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}