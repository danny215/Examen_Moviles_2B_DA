package com.example.dann.tiendapokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_detalles_pokemon.*

class DetallesPokemonActivity : AppCompatActivity() {

    var pokemon: Pokemon? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_pokemon)

        pokemon = intent.getParcelableExtra("detallesPokemon")


        txtShowNumeroPokemon.text = pokemon?.numeroPokemon.toString()
        txtShowNombrePokemon.text = pokemon?.nombre
        txtShowPoderUno.text = pokemon?.poderUno
        txtShowPoderDos.text = pokemon?.poderDos
        txtShowFechaC.text = pokemon?.fechaCaptura
        txtShowNivel.text = pokemon?.nivel.toString()

        button3.setOnClickListener { v: View? ->
            enviarDatos()
        }


    }

    fun enviarDatos(){


    }
}
