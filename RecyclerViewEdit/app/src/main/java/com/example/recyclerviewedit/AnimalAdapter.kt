package com.example.recyclerviewedit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewedit.databinding.ActivityEditBinding

class AnimalAdapter: RecyclerView.Adapter<AnimalAdapter.AnimalHolder>() {

    var animalsList = arrayListOf<Animal>()

    class AnimalHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ActivityEditBinding.bind(item)
        fun bind(animal: Animal) = with(binding) {
            imageView.setImageResource(animal.imageID)
            animal.title = editTitle.text.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_item, parent, false)
        return AnimalHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) {
        holder.bind(animalsList[position])
    }

    override fun getItemCount(): Int {
        return animalsList.size
    }

    fun addAnimal(animal: Animal) {
        animalsList.add(animal)
    }

}