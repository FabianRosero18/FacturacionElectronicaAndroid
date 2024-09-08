package com.mycompany.facturacionelectronica.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mycompany.facturacionelectronica.database.entities.Cliente
import com.mycompany.facturacionelectronica.database.entities.Factura

/*
* Cuando usas la biblioteca de persistencias Room para almacenar los datos de tu app, interactúas con los datos almacenados a través de la definición
* de objetos de acceso a datos o DAO. Cada DAO incluye métodos que ofrecen acceso abstracto a la base de datos de tu app. En el tiempo de compilación,
* Room genera automáticamente implementaciones de los DAOs que definas.
*/

@Dao
interface ClienteDao {

    //Métodos de conveniencia que te permiten insertar, actualizar y borrar filas en tu base de datos sin escribir ningún código de SQL.
    @Insert
    fun crearCliente(clientes : Cliente)

    @Insert
    fun crearFactura(factura: Factura)

    //Métodos de búsqueda que te permiten escribir tu propia consulta en SQL para interactuar con la base de datos.
    @Query("SELECT * FROM Cliente WHERE id = :id")
    fun consultarPorId(id: Int): Cliente?




   /* */

}