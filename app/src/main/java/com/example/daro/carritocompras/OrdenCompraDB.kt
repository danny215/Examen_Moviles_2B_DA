package com.example.daro.carritocompras

import android.os.StrictMode
import android.util.Log
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.example.daro.carritocompras.R.string.apellido
import com.example.daro.carritocompras.R.string.nombre
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost

class OrdenCompraDB{
    companion object {
        fun insertarOrden(ordenCompraKotlinClass: OrdenCompraKotlinClass){
            "http://192.168.100.26:1337/OrdenCompra".httpPost(listOf("cedulaIdentidad" to ordenCompraKotlinClass.cedulaComprador, "nombre" to ordenCompraKotlinClass.nombre,
                    "apellido" to ordenCompraKotlinClass.apellido,"edad" to ordenCompraKotlinClass.edad,"sector" to ordenCompraKotlinClass.sector,"idPokemon" to ordenCompraKotlinClass.idPokemon))
                    .responseString { request, _, result ->
                        Log.d("http-ejemplo", request.toString())
                    }
        }

        fun insertarOrdenDetalles(ordenDetalles: OrdenDetalles){
            "http://192.168.100.26:1337/OrdenDetalle".httpPost(listOf("fechaEnvio" to ordenDetalles.fechaEnvio, "precio" to ordenDetalles.precio, "idPokemon" to ordenDetalles.idPokemon))
                    .responseString { request, _, result ->
                        Log.d("http-ejemplo", request.toString())
                    }
        }



        fun getOrdenesList(): ArrayList<OrdenCompraKotlinClass> {
            val ordenKotlinClass: ArrayList<OrdenCompraKotlinClass> = ArrayList()
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val (request, response, result) = "http://192.168.100.26:1337/OrdenCompra".httpGet().responseString()
            val jsonStringPokemon = result.get()

            val parser = Parser()
            val stringBuilder = StringBuilder(jsonStringPokemon)
            val array = parser.parse(stringBuilder) as JsonArray<JsonObject>

            array.forEach {
                val cedulaIdentidad = it["cedulaIdentidad"] as Int
                val nombreC = it["nombre"] as String
                val apellidoC = it["apellido"] as String
                val edadC = it["edad"] as Int
                val sector = it["sector"] as String
                val idPokemon = it["idPokemon"] as Int
                //val latitud = it["latitud"] as Double
                // val longitud = it["longitud"] as Double
                val ordenn = OrdenCompraKotlinClass(0,cedulaIdentidad,nombreC,apellidoC,edadC,sector,idPokemon)
                ordenKotlinClass.add(ordenn)
            }
            return ordenKotlinClass
        }
    }



}