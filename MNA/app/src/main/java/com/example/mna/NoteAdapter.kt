package com.example.mna

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mna.databinding.NoteItemBinding

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    var notesList = arrayListOf<Note>()

    class NoteHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = NoteItemBinding.bind(item)
        fun bind(note: Note) = with(binding) {
            itemNoteTitle.text = note.title
            itemNoteContent.text = note.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteHolder(view)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.bind(notesList[position])
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addNote(note: Note) {
        notesList.add(note)
        notifyDataSetChanged()
    }

}