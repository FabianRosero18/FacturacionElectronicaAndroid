package com.mycompany.facturacionelectronica.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


/*Define cada entidad de Room como una clase con @Entity como anotación. Una entidad de Room incluye campos para cada columna de la tabla correspondiente
en la base de datos, incluidas una o más columnas que conforman la clave primaria.*/

//Si quieres que la tabla tenga un nombre diferente, configura la propiedad tableName de la anotación @Entity.
@Entity(tableName = "cliente")
//la clase debe ser del tipo data class, ya que se usa para el manejo de datos
data class Cliente(

    //definiendo la primaryKey
    @PrimaryKey
    val id:Long?,
    //demas campos de la base de datos
    val tipoId:String?,
    val nombre:String?,
    val direccion:String?,
    val telefono:String?,
    val ciudad:String?,
    val formaPago:String?,
    val correoFe:String?
)
