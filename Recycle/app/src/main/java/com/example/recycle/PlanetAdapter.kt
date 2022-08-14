package com.example.recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycle.databinding.PlanetItemBinding

class PlanetAdapter: RecyclerView.Adapter<PlanetAdapter.PlanetHolder>() {

    val planetsList = ArrayList<Planet>()

    class PlanetHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PlanetItemBinding.bind(item)
        fun bind(planet: Planet) = with(binding) {
            imageView.setImageResource(planet.imageId)
            textView.text = planet.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.planet_item, parent, false)
        return PlanetHolder(view)
    }

    override fun onBindViewHolder(holder: PlanetHolder, position: Int) {
        holder.bind(planetsList[position])
    }

    override fun getItemCount(): Int {
        return planetsList.size
    }

    public fun addPlanet(planet: Planet) {
        planetsList.add(planet)
    }


}