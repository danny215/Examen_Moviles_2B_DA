package com.example.daro.carritocompras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_listar_entrenadores.*

class ListarPokemonAActivity : AppCompatActivity() {

    lateinit var adaptador: PokemonAdapter
    lateinit var pokemones: ArrayList<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_pokemon)

        pokemones = DatabasePokemon.getPokemonList(entrenadorId = 1)


        val layoutManager = LinearLayoutManager(this)
        adaptador = PokemonAdapter(pokemones)
        recyclerViewEntrenador.layoutManager = layoutManager
        recyclerViewEntrenador.itemAnimator = DefaultItemAnimator()
        recyclerViewEntrenador.adapter = adaptador
        adaptador.notifyDataSetChanged()

        registerForContextMenu(recyclerViewEntrenador)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var position = adaptador.getPosition()
        var pokemon = pokemones[position]

        when (item.itemId) {


            R.id.item_menu_eliminar -> {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Esta seguro de eliminar")
                        .setPositiveButton("Si", { dialog, which ->
                            DatabaseEntrenador.eliminarEntrenador(pokemon.id)
                            finish()
                            startActivity(intent)
                        }
                        )
                        .setNegativeButton("No", null)
                val dialogo = builder.create()
                dialogo.show()
                return true
            }
            else -> {
                Log.i("menu", "Todos los demas")
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
