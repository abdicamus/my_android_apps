package com.example.navigationviewactivity

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.navigationviewactivity.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            sendButton.setOnClickListener {
                if (textToActivity.text.isNullOrEmpty()) textToActivity.error = "Please enter text"
                dataModel.message.value = textToActivity.text.toString()
            }
        }
    }

    companion object {
        fun newInstance() = FirstFragment()
    }
}