package com.example.myrecycleact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myrecycleact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = AnimalAdapter()
    private var launcher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                adapter.addAnimal(it.data?.getSerializableExtra("animal") as Animal)
            }
        }
    }

    fun init() {
        binding.recycleView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        binding.recycleView.adapter = adapter
        binding.addButton.setOnClickListener {
            launcher?.launch(Intent(this@MainActivity, EditActivity::class.java))
        }
    }
}