package com.example.remaining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.remaining.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun onClick(view: View) {
        if (!isInputEmpty()) {
            Toast.makeText(applicationContext, "Результат равен -> ${getResult()}", Toast.LENGTH_SHORT).show()
        }
    }

    fun isInputEmpty(): Boolean {
        binding.apply {
            if (inputA.text.isNullOrEmpty()) inputA.error = "Поле должно быть заполнено"
            if (inputB.text.isNullOrEmpty()) inputB.error = "Поле должно быть заполнено"
            if (inputC.text.isNullOrEmpty()) inputC.error = "Поле должно быть заполнено"
            return inputA.text.isNullOrEmpty() || inputB.text.isNullOrEmpty() || inputC.text.isNullOrEmpty()
        }
    }

    fun getResult(): String {
        val a: Double
        val b: Double
        val c: Double
        binding.apply {
            a = inputA.text.toString().toDouble()
            b = inputB.text.toString().toDouble()
            c = inputC.text.toString().toDouble()
        }
        return (b.pow(2) - (4 * a * c)).toInt().toString()
    }
}