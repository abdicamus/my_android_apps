package com.example.superapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.superapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var name: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.preRegButton.setOnClickListener {
            val intent = Intent(this, RegistryActivity::class.java)
            startActivityForResult(intent, 100)
        }


        binding.enterButton.setOnClickListener {

            if (binding.name.text.toString() == name) {
                if (binding.password.text.toString() == password) {
                    Toast.makeText(applicationContext, "Welcome ${binding.name.text}", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LogInActivity::class.java).putExtra("myName", binding.name.text.toString()))
                    binding.name.text.clear()
                    binding.password.text.clear()
                } else {
                    Toast.makeText(applicationContext, "Неверный пароль", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(applicationContext, "Пользователь не найден", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            name = data.getStringExtra("name").toString()
            password = data.getStringExtra("password").toString()
        }
    }
}