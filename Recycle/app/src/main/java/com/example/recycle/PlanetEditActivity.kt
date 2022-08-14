package com.example.recycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recycle.databinding.ActivityPlanetEditBinding

class PlanetEditActivity : AppCompatActivity() {

    lateinit var binding: ActivityPlanetEditBinding
    private var imageID = R.drawable.earth
    private var imageIndex = 0
    private var imagesList = arrayListOf(
        R.drawable.earth,
        R.drawable.jupiter,
        R.drawable.mars,
        R.drawable.mercury,
        R.drawable.neptune,
        R.drawable.pluto,
        R.drawable.saturn,
        R.drawable.uranus,
        R.drawable.venus
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            nextImageButton.setOnClickListener {
                imageIndex++
                if (imageIndex == imagesList.size) imageIndex = 0
                imageID = imagesList[imageIndex]
                editImage.setImageResource(imageID)
            }

            doneButton.setOnClickListener {
                val planet = Planet(imageID, editTitle.text.toString(), editDescription.text.toString())
                val intent = Intent().putExtra("planet", planet)
                setResult(RESULT_OK, intent)
                finish()
            }

        }
    }
}