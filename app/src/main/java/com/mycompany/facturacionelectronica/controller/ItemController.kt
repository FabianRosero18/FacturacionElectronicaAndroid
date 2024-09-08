package com.mycompany.facturacionelectronica.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mycompany.facturacionelectronica.database.RoomApp
import com.mycompany.facturacionelectronica.database.entities.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemController: ViewModel() {

    fun insertarItem(codigo: String,
                     descripcion:String,
                     cantidad:String,
                     valorUnidad:String){

        viewModelScope.launch(Dispatchers.IO){

            val factura = RoomApp.room.FacturaDao().consultarUltimaFactura()

            val item = Item(
                codigo = codigo,
                descripcion = descripcion,
                cantidad = cantidad.toInt(),
                valorUnitario = valorUnidad.toInt(),
                idFactura = factura.id
            )

            RoomApp.room.FacturaDao().crearItem(item)
        }

    }
}