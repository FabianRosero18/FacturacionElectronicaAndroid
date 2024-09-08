package com.mycompany.facturacionelectronica.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.mycompany.facturacionelectronica.R
import com.mycompany.facturacionelectronica.controller.LogginController


class MainActivity : ComponentActivity() {

    lateinit var user: EditText
    lateinit var pass: EditText
    lateinit var button : Button
    lateinit var buttonCliente: Button
    lateinit var buttonFactura: Button
    private val viewModel:LogginController by viewModels()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val intent = Intent(this,FacturaActivity::class.java)
        //startActivity(intent)

        setContentView(R.layout.main_activity)

        user = findViewById(R.id.user)
        pass = findViewById(R.id.pass)
        button = findViewById(R.id.buttonloggin)
        buttonCliente = findViewById(R.id.buttonCliente)
        buttonFactura = findViewById(R.id.buttonFactura)

        viewModel.crearUsuarios()
        viewModel.listarUsuarios()

        //funcion para verificar que hubo un click en el boton, con el id buttonloggin
        button.setOnClickListener {

            val usuario = user.text.toString()
            val contrasena = pass.text.toString()

            var validacion = viewModel.validarUsuario(usuario,contrasena)


                if (validacion) {
                    if(usuario.equals("administrativo")) {
                        buttonCliente.visibility = View.VISIBLE
                        buttonFactura.visibility = View.VISIBLE
                    }
                    else if(usuario.equals("facturador")){
                        buttonFactura.visibility = View.VISIBLE
                    }
                    Log.d("validacion ", "ingresa")
                } else {
                    buttonCliente.visibility = View.INVISIBLE
                    buttonFactura.visibility = View.INVISIBLE
                    Toast.makeText(this,"usuario o contraseña incorrectos",Toast.LENGTH_LONG).show()
                    //Log.d("validacion ", "no ingresa")
                }

            //estas funciones sirven para esconder el teclado y que no estorbe la vista al dar click
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(pass.windowToken,0)

        }
    }
    //funcion para verificar si
    fun moduloClientes(view : View){

        val intent = Intent(this,ClienteActivity::class.java)
        startActivity(intent)

    }
    fun moduloFacturas(view : View){

        val intent = Intent(this,FacturaActivity::class.java)
        startActivity(intent)

    }

}
