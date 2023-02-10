package com.gustavo.pokedex.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gustavo.pokedex.databinding.FragmentPokeItemBinding
import com.gustavo.pokedex.model.Pokemon

class PokemonAdapter(
    private val values: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentPokeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        item?.let { pokemon ->
            Glide.with(holder.img).load(pokemon.imageUrl).into(holder.img)
            holder.id.text = pokemon.formattedId()
            holder.name.text = pokemon.formattedName
            holder.firstPokeType.text = pokemon.types.first().name
            holder.secondPokeType.text = pokemon.types.last().name
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentPokeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val img = binding.pokeImg
        val id = binding.pokeId
        val name = binding.pokeName
        val firstPokeType = binding.pokeType1
        val secondPokeType = binding.pokeType2
    }
}