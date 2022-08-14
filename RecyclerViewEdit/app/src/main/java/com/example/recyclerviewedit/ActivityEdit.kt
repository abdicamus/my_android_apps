package com.example.recyclerviewedit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewedit.databinding.ActivityEditBinding

class ActivityEdit : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding
    private var imageID = R.drawable.cat
    private var imageIndex = 0

    private val imagesList = arrayListOf(
        R.drawable.cat,
        R.drawable.cow,
        R.drawable.dog,
        R.drawable.duck,
        R.drawable.lion,
        R.drawable.panda
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            nextImageButton.setOnClickListener {
                imageIndex++
                if (imageIndex == imagesList.size) imageIndex = 0
                imageID = imagesList[imageIndex]
                imageView.setImageResource(imageID)
            }

            doneButton.setOnClickListener {
                val animal = Animal(imageID, editTitle.text.toString(), editDescription.text.toString())
                val intent = Intent().putExtra("animal", animal)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}