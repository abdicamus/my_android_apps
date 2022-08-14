package com.example.mna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mna.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            doneButton.setOnClickListener {
                val intent = Intent().putExtra("title", noteTitle.text.toString())
                intent.putExtra("note", noteContent.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}