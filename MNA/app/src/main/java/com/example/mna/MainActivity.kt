package com.example.mna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mna.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter = NoteAdapter()
    lateinit var launcher: ActivityResultLauncher<Intent>
    private var noteList = arrayListOf<Note>()
    lateinit var noteTitle: String
    lateinit var noteContent: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.refreshButton.setOnClickListener {
            init()
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                noteTitle = it.data?.getStringExtra("title").toString()
                noteContent = it.data?.getStringExtra("note").toString()
                adapter.addNote((Note(noteTitle, noteContent)))
                Log.d("mylog", "Size of list: ${noteList.size.toString()}")
            }
        }

        binding.apply {
            addNote.setOnClickListener {
                launcher.launch(Intent(this@MainActivity, AddNoteActivity::class.java))
            }
        }
    }

    fun init() {
        binding.apply {
            recycleView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recycleView.adapter = adapter

        }
    }
}