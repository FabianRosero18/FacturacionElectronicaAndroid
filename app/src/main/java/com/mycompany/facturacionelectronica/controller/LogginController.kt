package com.mycompany.facturacionelectronica.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mycompany.facturacionelectronica.database.RoomApp
import com.mycompany.facturacionelectronica.database.entities.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LogginController : ViewModel(){

    var usuarios: List<Usuario>? = null


    fun crearUsuarios(){

        val usuario1 = Usuario(user = "administrativo", contrasenia = "s2020")
        val usuario2 = Usuario(user = "facturador", contrasenia = "s2010")
        //esta es una corrutina y sirve para ejecutar la busqueda de manera asincrona, fuera del hilo principal
        viewModelScope.launch (Dispatchers.IO){
            //aqui creamos a los usuarios, usando el DAO y pasandole los valores del tipo usuario
            RoomApp.room.UsuarioDao().crearUsuario(listOf(usuario1,usuario2))
        }
    }

    fun listarUsuarios() {

        //esta es una corrutina y sirve para ejecutar la busqueda de manera asincrona, fuera del hilo principal

        viewModelScope.launch(Dispatchers.IO) {
            //aqui hacemos la consulta de los usuarios desde el DAO y lo guardamos en una variable
            //del tipo lista de usuarios
            usuarios = RoomApp.room.UsuarioDao().consultarUsuarios()
        }
    }
    fun validarUsuario(username:String,pass:String):Boolean{

        var validacion = false
        //Log.d("user",usuarios.toString())

        //foreach para recorrer la lista consultada de usuarios
        usuarios?.forEach {

            if (username.equals(it.user)) {
                if (pass.equals(it.contrasenia)) {
                    validacion = true
                }
                else {
                    validacion = false
                }
            }
        }
        return validacion
    }
}