package com.mycompany.facturacionelectronica.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.mycompany.facturacionelectronica.database.entities.Item

@Dao
interface ItemDao {

    @Query("SELECT * FROM item WHERE idFactura= :idFactura")
    suspend fun consultarItems(idFactura : Long): List<Item>

}