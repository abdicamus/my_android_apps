package com.example.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.firstapplication.databinding.ActivityMainBinding
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        var firstNumber = Random.nextInt(1, 100)
        var secondNumber = Random.nextInt(1, 100)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.firstNumber.text = firstNumber.toString()
        binding.secondNumber.text = secondNumber.toString()
        binding.button.text = "Сумма"
        binding.button2.text = "Разность"
        binding.generateButton.text = "Сгенерировать новые числа"
        binding.button.setOnClickListener {
            binding.resultText.text = (firstNumber + secondNumber).toString()
            binding.resultText.visibility = View.VISIBLE
        }

        binding.button2.setOnClickListener {
            binding.resultText.text = (firstNumber - secondNumber).toString()
            binding.resultText.visibility = View.VISIBLE
        }

        binding.generateButton.setOnClickListener {
            firstNumber = Random.nextInt(1, 100)
            secondNumber = Random.nextInt(1, 100)
            binding.firstNumber.text = firstNumber.toString()
            binding.secondNumber.text = secondNumber.toString()
        }

    }


}