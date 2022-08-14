package com.example.myrecycleact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myrecycleact.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding
    private var imageID = R.drawable.cat
    private var imageIndex = 0
    private val animalsList = arrayListOf(
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
                if (imageIndex == animalsList.size) imageIndex = 0
                imageID = animalsList[imageIndex]
                imageView.setImageResource(imageID)
            }

            doneButton.setOnClickListener {
                val animal = Animal(imageID, editTitle.text.toString(), editDescription.text.toString())
                val myIntent = Intent().putExtra("animal", animal)
                setResult(RESULT_OK, myIntent)
                finish()
            }
        }
    }
}