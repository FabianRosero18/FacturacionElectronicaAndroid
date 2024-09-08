package com.mycompany.facturacionelectronica.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.mycompany.facturacionelectronica.controller.FacturaController
import com.mycompany.facturacionelectronica.controller.ItemController
import com.mycompany.facturacionelectronica.databinding.ItemActivityBinding

class ItemActivity: ComponentActivity() {

    private lateinit var binding: ItemActivityBinding
    private val item: ItemController by viewModels()
    private val factura: FacturaController by viewModels()
    var consecutivo = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    fun insertarItem(view: View){


        item.insertarItem(
            binding.codigo.text.toString(),
            binding.descripcion.text.toString(),
            binding.cantidad.text.toString(),
            binding.valorUnidad.text.toString()
        )

        Toast.makeText(this,"Item insertado", Toast.LENGTH_LONG).show()


        binding.codigo.setText("")
        binding.descripcion.setText("")
        binding.cantidad.setText("")
        binding.valorUnidad.setText("")

    }
    fun generarFactura(view: View){
        factura.actualizarFactura()
        val intent = Intent(this,VistaFacturaActivity::class.java)
        startActivity(intent)
    }
}