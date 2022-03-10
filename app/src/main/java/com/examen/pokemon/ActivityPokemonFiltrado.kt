package com.examen.pokemon

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.examen.pokemon.databinding.ActivityMainBinding


var listas: List<Pokemon>? = null

class ActivityPokemonFiltrado : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ActivityMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataPokemon= intent.getStringExtra("datapokemon")
        val url = "${dataPokemon}"
        viewModel.descargarPokemons(url)
        initObserver()
    }

    private fun initObserver() {
        viewModel.isVisible.observe(this) { isVisible ->
            if (isVisible) setVisible() else setGone()
        }

        viewModel.responseText.observe(this) { responseText ->
            showToast(responseText)
        }

        viewModel.responseList.observe(this) {
            setRecycler(it as MutableList<Pokemon>)
        }
    }
    private fun setVisible() {
        binding.pbDownloading.visibility = View.VISIBLE
    }

    private fun setGone() {
        binding.pbDownloading.visibility = View.GONE
    }

    private fun showToast(text: String) {
        Toast.makeText(this@ActivityPokemonFiltrado, text, Toast.LENGTH_SHORT).show()

    }

    private fun setRecycler(lista: MutableList<Pokemon>) {

        val adapter = PokemonFiltradoAdapter(lista)


        listas = lista
        binding.recycler.layoutManager = LinearLayoutManager(this@ActivityPokemonFiltrado)
        binding.recycler.adapter = adapter
    }
}