package com.mycompany.facturacionelectronica.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "factura")
data class Factura (

    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,
    val fechaRealizacion:String?,
    val fechaVencimiento:String?,
    val ordenCompra: String?,
    val remision:String?,
    val observaciones:String?,
    val subtotal:Int?,
    val iva:Int?,
    val retefuente:Int?,
    val total:Int?,
    val idCliente:Long?
)