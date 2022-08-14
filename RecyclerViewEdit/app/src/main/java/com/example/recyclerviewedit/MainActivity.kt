package com.example.recyclerviewedit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewedit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var adapter = AnimalAdapter()
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

    private fun init() = with(binding) {
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        recyclerView.adapter = adapter
        addButton.setOnClickListener {
            launcher?.launch(Intent(this@MainActivity, ActivityEdit::class.java))
        }
    }
}