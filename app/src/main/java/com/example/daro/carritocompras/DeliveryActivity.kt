package com.example.daro.carritocompras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_delivery.*

class DeliveryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery)

        btn_adquiridos.setOnClickListener { v: View? ->
            irActividadAdquiridos()
        }
        btn_ubicacion.setOnClickListener { v: View? ->
            irActividadAdquiridos()
        }

    }

    fun irActividadAdquiridos(){
        val intent = Intent(this, ListarPokemonAActivity::class.java)
        intent.putExtra("tipo", "Create")
        startActivity(intent)
    }
}
