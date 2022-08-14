package com.example.myrecycleact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecycleact.databinding.AnimalItemBinding

class AnimalAdapter: RecyclerView.Adapter<AnimalAdapter.AnimalHolder>() {

    val animalsList = arrayListOf<Animal>()

    class AnimalHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = AnimalItemBinding.bind(item)
        fun bind(animal: Animal) = with(binding) {
            imageView2.setImageResource(animal.imageId)
            textView.text = animal.title
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