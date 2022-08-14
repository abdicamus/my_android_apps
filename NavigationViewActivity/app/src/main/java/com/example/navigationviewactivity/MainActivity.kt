package com.example.navigationviewactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.transition.Slide
import com.example.navigationviewactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            button.setOnClickListener {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.top_frame, FirstFragment.newInstance())
                    .commit()

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottom_frame, SecondFragment.newInstance())
                    .commit()
            }
        }

        dataModel.message.observe(this) {
            binding.textView.text = it
        }

    }
}
