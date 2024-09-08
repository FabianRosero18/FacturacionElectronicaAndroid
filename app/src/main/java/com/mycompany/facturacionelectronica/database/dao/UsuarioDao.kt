package com.mycompany.facturacionelectronica.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mycompany.facturacionelectronica.database.entities.Usuario

@Dao
interface UsuarioDao {

    @Insert
    suspend fun crearUsuario(usuarios : List<Usuario>)

    @Query("SELECT * FROM Usuario")
    suspend fun consultarUsuarios():List<Usuario>

}