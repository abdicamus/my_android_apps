package com.example.activitiesmoves

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.inflate
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activitiesmoves.databinding.ActivityMainBinding
import com.example.activitiesmoves.databinding.ActivityMainBinding.bind
import com.example.activitiesmoves.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {

    lateinit var bindingMain: ActivityMainBinding
    private var launcher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                bindingMain.resultText.text = result.data?.getStringExtra("fromSecond")
                bindingMain.button2.text = result.data?.getStringExtra("fromThird")
            }
        }
    }


    fun OnClickToSecondAct(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name", bindingMain.name.text.toString())
        launcher?.launch(intent)
    }

    fun OnClickToThirdAct(view: View) {
        launcher?.launch(Intent(this, ThirdActivity::class.java).putExtra("key", "fromMainActivity"))
    }
}