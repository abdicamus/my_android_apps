package com.example.superapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.superapp.databinding.ActivityRegistryBinding

class RegistryActivity : AppCompatActivity() {

    lateinit var regBinding: ActivityRegistryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        regBinding = ActivityRegistryBinding.inflate(layoutInflater)
        setContentView(regBinding.root)



        regBinding.registryButton.setOnClickListener {


            if ((regBinding.regName.text.isNotEmpty()) and (regBinding.regPassword.text.isNotEmpty())) {
                intent.putExtra("name", regBinding.regName.text.toString())
                intent.putExtra("password", regBinding.regPassword.text.toString())
                setResult(RESULT_OK, intent)
                Toast.makeText(applicationContext, "Пользователь успешно зарегистрирован", Toast.LENGTH_SHORT).show()
                finish()
            } else if ((regBinding.regName.text.isEmpty()) or (regBinding.regPassword.text.isEmpty())) {
                Toast.makeText(applicationContext, "Пожалуйста введите все данные", Toast.LENGTH_SHORT).show()
            }

        }
    }
}