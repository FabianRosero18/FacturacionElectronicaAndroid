package com.mycompany.facturacionelectronica.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mycompany.facturacionelectronica.database.RoomApp
import com.mycompany.facturacionelectronica.database.entities.Cliente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClienteController : ViewModel(){

    private var clienteEncontrado: Cliente? = null

    fun crearCliente(id: String,
                     tipoId: String,
                     nombre: String,
                     direccion: String,
                     telefono: String,
                     ciudad: String,
                     formaPago: String,
                     correoFe: String)
    {
        val cliente = Cliente(id = id.toLong(),
                                tipoId = tipoId,
                                nombre = nombre,
                                direccion = direccion,
                                telefono = telefono,
                                ciudad = ciudad,
                                formaPago = formaPago,
                                correoFe = correoFe)

        viewModelScope.launch (Dispatchers.IO){
            RoomApp.room.ClienteDao().crearCliente(cliente)
        }
    }
     fun listarClientes(id: String){

         if(id != ""){
            viewModelScope.launch(Dispatchers.IO) {
                clienteEncontrado = RoomApp.room.ClienteDao().consultarPorId(id.toInt())
            }
         }
    }
    fun getClienteEncontrado():Cliente?{
        return clienteEncontrado
    }

}