package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentCounterBinding
import com.github.javafaker.Faker


class CounterFragment : Fragment() {
    private lateinit var binding: FragmentCounterBinding
    private val faker = Faker.instance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCounterBinding.inflate(inflater, container, false)
        binding.generateQuote.setOnClickListener {
            binding.quote.text = createQuote()
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CounterFragment()
    }

    private fun createQuote() : String = faker.harryPotter().quote()

}