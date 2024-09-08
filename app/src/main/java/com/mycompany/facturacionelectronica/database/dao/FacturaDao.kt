package com.mycompany.facturacionelectronica.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.mycompany.facturacionelectronica.database.entities.Factura
import com.mycompany.facturacionelectronica.database.entities.Item
import com.mycompany.facturacionelectronica.database.entities.relations.ClienteConFacturas
import com.mycompany.facturacionelectronica.database.entities.relations.FacturaConItems

@Dao
interface FacturaDao {

    //el OnConflictStrategy.REPLACE se usa para editar, en tal caso que encuentre un ID igual lo va a reemplazar con los nuevos datos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun crearFactura(factura: Factura)

    @Insert
    fun crearItem(item: Item)

    @Transaction
    @Query("SELECT * FROM Factura WHERE idCliente = :idCliente")
    fun consultarFacturasCliente (idCliente: Long):List<ClienteConFacturas>

    @Query("SELECT * FROM factura ORDER BY id DESC LIMIT 1 ")
    fun consultarUltimaFactura():Factura

    @Query("SELECT * FROM factura WHERE id =:id")
    fun consultarItemsFactura (id: Long):List<FacturaConItems>

}