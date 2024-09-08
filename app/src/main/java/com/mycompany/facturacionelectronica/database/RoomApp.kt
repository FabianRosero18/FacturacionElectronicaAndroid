package com.mycompany.facturacionelectronica.database

import android.app.Application
import androidx.room.Room

class RoomApp : Application(){

    companion object{
        lateinit var room:FacturaElectronicaDb
    }

    override fun onCreate() {
        super.onCreate()

        //este es el atributo room que se crea para el manejo de la base de datos en el programa
        room = Room.databaseBuilder(
                applicationContext,
                FacturaElectronicaDb::class.java,
                "facturaelectronica")
            //este metodo se usa para corregir el error: "Room cannot verify the data integrity"
            .fallbackToDestructiveMigration()
            .build()
    }
}