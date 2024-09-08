package com.mycompany.facturacionelectronica.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Item(

    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,
    val codigo:String,
    val descripcion:String,
    val cantidad:Int,
    val valorUnitario:Int,
    val idFactura:Long,
)
