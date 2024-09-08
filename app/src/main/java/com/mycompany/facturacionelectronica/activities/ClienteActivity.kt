package com.mycompany.facturacionelectronica.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.mycompany.facturacionelectronica.R
import com.mycompany.facturacionelectronica.controller.ClienteController

class ClienteActivity : ComponentActivity(){

    lateinit var id: EditText
    lateinit var tipoId: EditText
    lateinit var nombre: EditText
    lateinit var direccion: EditText
    lateinit var telefono: EditText
    lateinit var ciudad: EditText
    lateinit var formaPago: EditText
    lateinit var correoFe: EditText
    private val client:ClienteController by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.cliente_activity)

        id = findViewById(R.id.id)
        tipoId = findViewById(R.id.tipoId)
        nombre = findViewById(R.id.nombre)
        direccion = findViewById(R.id.direccion)
        telefono = findViewById(R.id.telefono)
        ciudad = findViewById(R.id.ciudad)
        formaPago = findViewById(R.id.formaPago)
        correoFe = findViewById(R.id.correoFe)

    }
    fun crearCliente(view : View){

        client.crearCliente(id.text.toString(),
                            tipoId.text.toString(),
                            nombre.text.toString(),
                            direccion.text.toString(),
                            telefono.text.toString(),
                            ciudad.text.toString(),
                            formaPago.text.toString(),
                            correoFe.text.toString()
        )

        Toast.makeText(this,"Cliente creado exitosamente", Toast.LENGTH_LONG).show()

        id.setText("")
        tipoId.setText("")
        nombre.setText("")
        direccion.setText("")
        telefono.setText("")
        ciudad.setText("")
        formaPago.setText("")
        correoFe.setText("")

    }
    fun moduloFacturas(view: View){

        val intent = Intent(this,FacturaActivity::class.java)
        startActivity(intent)
    }
}