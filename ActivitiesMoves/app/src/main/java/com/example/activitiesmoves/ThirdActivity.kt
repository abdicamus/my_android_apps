package com.example.activitiesmoves

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activitiesmoves.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    lateinit var binding3: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding3 = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding3.root)

        binding3.textView3.text = intent.getStringExtra("key").toString()

        binding3.button3.setOnClickListener {
            intent.putExtra("fromThird", binding3.thirdEditText.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}