package com.example.navigationviewactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationviewactivity.databinding.ActivityMainBinding
import com.example.navigationviewactivity.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSecondBinding.inflate(inflater)

        binding.apply {
            changeColorButton.setOnClickListener {
                myView.setBackgroundResource(R.color.purple_200)
            }
        }


        return binding.root


    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }

}