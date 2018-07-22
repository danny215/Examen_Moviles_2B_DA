package com.example.dann.tiendapokemon

import android.os.Parcel
import android.os.Parcelable

class OrdenCompraKotlinClass(var idCompra:Int, var cedulaComprador:Int, var nombre: String, var apellido:String, var edad:Int, var sector:String, var idPokemon:Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idCompra)
        parcel.writeInt(cedulaComprador)
        parcel.writeString(nombre)
        parcel.writeString(apellido)
        parcel.writeInt(edad)
        parcel.writeString(sector)
        parcel.writeInt(idPokemon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OrdenCompraKotlinClass> {
        override fun createFromParcel(parcel: Parcel): OrdenCompraKotlinClass {
            return OrdenCompraKotlinClass(parcel)
        }

        override fun newArray(size: Int): Array<OrdenCompraKotlinClass?> {
            return arrayOfNulls(size)
        }
    }
}