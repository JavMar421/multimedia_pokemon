package com.examen.pokemon

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.examen.pokemon.databinding.RecyclerviewBinding


class RecyclerAdapter(var pokemons: MutableList<Result>) :
    RecyclerView.Adapter<RecyclerAdapter.TextoViewHolder>() {


    class TextoViewHolder(var itemBinding: RecyclerviewBinding) :
        RecyclerView.ViewHolder(itemBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextoViewHolder {
        val binding =
            RecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextoViewHolder(binding)

    }

    override fun onBindViewHolder(holder: TextoViewHolder, pos: Int) {

        holder.itemBinding.name.text = pokemons[pos].name
        holder.itemBinding.all.setOnClickListener {
           val intent = Intent(holder.itemBinding.root.context, ActivityPokemonFiltrado::class.java)
            intent.putExtra("datapokemon", pokemons[pos].url)
            holder.itemBinding.root.context.startActivity(intent)


        }
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

}