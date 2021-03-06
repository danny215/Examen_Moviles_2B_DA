package com.example.dann.tiendapokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_detalle_orden.*


class DetalleOrdenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var oredenes: OrdenCompraKotlinClass? = null


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_orden)

        oredenes = intent.getParcelableExtra("detallesOrden")

        txtShowCedula.text = oredenes?.cedulaComprador.toString()
        txtShowNombre.text = oredenes?.nombre
        txtShowApellido.text = oredenes?.apellido
        txtShowEdad.text = oredenes?.edad.toString()
        txtShowSector.text = oredenes?.sector
        txtShowIdPokemon.text = oredenes?.idPokemon.toString()

        btnGuardarDatosOrden.setOnClickListener { v: View? ->
            guardarDatosOrdenDetalles()

        }

        btnUbicacionComprador.setOnClickListener { v: View? ->
            irUbicacionActivity()

        }

    }

    fun guardarDatosOrdenDetalles(){
        val fechaEnvio = txtFechaEnvio.text.toString()
        val costoPokemon = txtPrecioPokemon.text.toString().toInt()
        val idPokemon = txtShowIdPokemon.text.toString().toInt()
        val ordenDetalles = OrdenDetalles(0,fechaEnvio,costoPokemon,idPokemon)
        OrdenCompraDB.insertarOrdenDetalles(ordenDetalles)
        Alerter.create(this)
                .setTitle("Orden enviada a Cliente")
                .setText("La solicitud fue enviada correctamente")
                .enableSwipeToDismiss()
                .show()
    }

    fun irUbicacionActivity(){
        val intent = Intent(this, GoogleMapsActivity::class.java)
        startActivity(intent)
    }
}
