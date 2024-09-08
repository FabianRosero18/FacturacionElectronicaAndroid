package com.mycompany.facturacionelectronica.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mycompany.facturacionelectronica.database.RoomApp
import com.mycompany.facturacionelectronica.database.entities.Factura
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FacturaController: ViewModel() {

    fun guardarFacturaInicial(
        fechaRealz: String,
        fechaVenc: String,
        ordenCompra: String,
        remision: String,
        observaciones: String,
        idCliente: String
    ) {
        /*val format = SimpleDateFormat("dd-MM-yyyy")
        val dateRealiz = format.parse(fechaRealz)
        val dateVenc = format.parse(fechaVenc)*/

        val factura = Factura(
            fechaRealizacion = fechaRealz,
            fechaVencimiento = fechaVenc,
            ordenCompra = ordenCompra,
            remision = remision,
            observaciones = observaciones,
            subtotal = 0,
            iva = 0,
            retefuente = 0,
            total = 0,
            idCliente = idCliente.toLong())

        viewModelScope.launch(Dispatchers.IO){

            RoomApp.room.ClienteDao().crearFactura(factura)

        }

    }

    fun actualizarFactura(){

        viewModelScope.launch (Dispatchers.IO){
            val facturaActual = RoomApp.room.FacturaDao().consultarUltimaFactura()
            val items = RoomApp.room.ItemDao().consultarItems(facturaActual.id)

            var subtotal = 0
            var auxiliar:Int?

            items.forEach {
                auxiliar = it.valorUnitario * it.cantidad
                subtotal += auxiliar!!
            }

            val iva = subtotal * 0.19
            val retefuente = subtotal * 0.025
            val total = (subtotal + iva)-retefuente

            val factura = Factura(
                id = facturaActual.id,
                fechaRealizacion = facturaActual.fechaRealizacion,
                fechaVencimiento = facturaActual.fechaVencimiento,
                ordenCompra = facturaActual.ordenCompra,
                remision = facturaActual.remision,
                observaciones = facturaActual.observaciones,
                subtotal = subtotal,
                iva = iva.toInt(),
                retefuente=retefuente.toInt(),
                total = total.toInt(),
                idCliente = facturaActual.idCliente
                )

            RoomApp.room.FacturaDao().crearFactura(factura)
        }

    }

}