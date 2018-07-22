package com.example.dann.tiendapokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_datos_comprador.*
import android.content.Intent



class DatosCompradorActivity : AppCompatActivity() {

    lateinit var idPokemonn:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_comprador)

       idPokemonn = intent.getStringExtra("idPokemon")

        //Toast.makeText(this,idPokemonn,Toast.LENGTH_SHORT).show()

        btnEnviarDatosComprador.setOnClickListener { v: View? ->
            crearOreden()
        }
        btn_regresar.setOnClickListener { v: View? ->
            regresar()
        }
        btnMapa.setOnClickListener { v: View? ->
            irUbicacionActivity()
        }
    }

    fun crearOreden(){
        var cedula = txtCedulaComprador.text.toString().toInt()
        var sector = txtSector.text.toString()
        var nombre = txtNombre.text.toString()
        var apellido = txtApellido.text.toString()
        var edad = txtEdad.text.toString().toInt()
        var idPokemon = idPokemonn.toString().toInt()

        var oredenCompra = OrdenCompraKotlinClass(0,cedula,nombre,apellido,edad,sector,idPokemon)
        OrdenCompraDB.insertarOrden(oredenCompra)

        Alerter.create(this)
                .setTitle("Datos Enviados a Delivery")
                .setText("Su peticion ha sido enviada correctamente")
                .setDuration(10000)
                .enableSwipeToDismiss()
                .setOnClickListener(View.OnClickListener {
                    irAbuscarEntrenador()
                }).show()


    }

    fun irAbuscarEntrenador(){
        txtCedulaComprador.setText("")
        txtSector.setText("")
        val intent = Intent(this,BuscarEntrenadorActivity::class.java)
        startActivity(intent)
    }
    fun regresar(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun irUbicacionActivity(){
        val intent = Intent(this, GoogleMapsActivity::class.java)
        startActivity(intent)
    }
}
