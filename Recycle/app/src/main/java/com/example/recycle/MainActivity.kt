package com.example.recycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter = PlanetAdapter()
    private var launcher: ActivityResultLauncher<Intent>? = null
    private val imagesList = listOf(
        R.drawable.mercury,
        R.drawable.venus,
        R.drawable.earth,
        R.drawable.mars,
        R.drawable.jupiter,
        R.drawable.saturn,
        R.drawable.uranus,
        R.drawable.neptune,
        R.drawable.pluto
    )

    private val imageNames = listOf(
        "Mercury",
        "Venus",
        "Earth",
        "Mars",
        "Jupiter",
        "Saturn",
        "Uranus",
        "Neptune",
        "Pluto")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                adapter.addPlanet(it.data?.getSerializableExtra("planet") as Planet)
            }
        }
    }

    private fun init() {
        binding.apply {
            recView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recView.adapter = adapter
            addButton.setOnClickListener {
                launcher?.launch(Intent(this@MainActivity, PlanetEditActivity::class.java))
            }
        }
    }
}