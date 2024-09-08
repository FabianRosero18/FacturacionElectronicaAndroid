package com.mycompany.facturacionelectronica.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.mycompany.facturacionelectronica.databinding.VistaFacturaActivityBinding

class VistaFacturaActivity : ComponentActivity(){

    private lateinit var binding: VistaFacturaActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VistaFacturaActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun moduloFactura(view: View){
        val intent = Intent(this,FacturaActivity::class.java)
        startActivity(intent)
    }
    fun moduloCliente(view: View){
        val intent = Intent(this,ClienteActivity::class.java)
        startActivity(intent)
    }
}