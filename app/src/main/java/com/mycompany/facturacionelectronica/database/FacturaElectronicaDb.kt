package com.mycompany.facturacionelectronica.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mycompany.facturacionelectronica.database.dao.ClienteDao
import com.mycompany.facturacionelectronica.database.dao.FacturaDao
import com.mycompany.facturacionelectronica.database.dao.ItemDao
import com.mycompany.facturacionelectronica.database.dao.UsuarioDao
import com.mycompany.facturacionelectronica.database.entities.Cliente
import com.mycompany.facturacionelectronica.database.entities.Factura
import com.mycompany.facturacionelectronica.database.entities.Item
import com.mycompany.facturacionelectronica.database.entities.Usuario

/*La clase debe tener una anotación @Database que incluya un array entities que enumere todas las entidades de datos asociados con la base de datos.*/
@Database(
    entities = arrayOf(Usuario::class, Cliente::class, Factura::class, Item::class),
    version = 3,
)
//Debe ser una clase abstracta que extienda RoomDatabase.

abstract class FacturaElectronicaDb : RoomDatabase(){

    /*Para cada clase DAO que se asoció con la base de datos, esta base de datos debe definir un método abstracto que tenga cero argumentos
    y muestre una instancia de la clase DAO.*/

    abstract fun UsuarioDao(): UsuarioDao

    abstract fun ClienteDao(): ClienteDao

    abstract fun FacturaDao(): FacturaDao

    abstract fun ItemDao(): ItemDao

}