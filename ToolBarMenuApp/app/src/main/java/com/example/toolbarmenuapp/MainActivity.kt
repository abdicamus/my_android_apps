package com.example.toolbarmenuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.toolbarmenuapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var launcher: ActivityResultLauncher<Intent>? = null
    private var infoList = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Bazinga"
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                binding.apply {
                    textName.text = it.data?.getStringExtra("name").toString()
                    textLastname.text = it.data?.getStringExtra("lastname").toString()
                    textSurname.text = it.data?.getStringExtra("surname").toString()
                    textAge.text = it.data?.getStringExtra("age").toString()
                }
            }
        }
        binding.bottomNavMenu.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.sync -> {
                    Toast.makeText(this, "Syncing", Toast.LENGTH_SHORT).show()
                    launcher?.launch(Intent(this, NameActivity::class.java))
                }
                R.id.save -> {
                    Toast.makeText(this, "Saving", Toast.LENGTH_SHORT).show()
                    launcher?.launch(Intent(this, LastnameActivity::class.java))
                }
                R.id.search -> {
                    Toast.makeText(this, "Searching", Toast.LENGTH_SHORT).show()
                    launcher?.launch(Intent(this, SurnameActivity::class.java))
                }
                R.id.delete -> {
                    Toast.makeText(this, "Deleting", Toast.LENGTH_SHORT).show()
                    launcher?.launch(Intent(this, AgeActivity::class.java))
                }
            }
            true
        }
    }

}