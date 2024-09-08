package com.mycompany.facturacionelectronica.activities

//https://medium.com/@alexisvaquero/como-hacer-un-date-picker-en-un-edittext-android-studio-kotlin-fa9ac184a04d

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.mycompany.facturacionelectronica.R
import com.mycompany.facturacionelectronica.controller.ClienteController
import com.mycompany.facturacionelectronica.controller.FacturaController
import com.mycompany.facturacionelectronica.databinding.FacturaActivityBinding
import java.time.LocalDateTime


class FacturaActivity : ComponentActivity(){

    //el binding se utiliza para reemplazar la obtencion de elementos por su id, ademas que asi se puede cargar el layout asociado
    //debe llevar el mismo orden del nombre del layout, finalizando con palabra "Binding": factura_activity.xml = FacturaActivityBinding
    private lateinit var binding: FacturaActivityBinding
    private val factura:FacturaController by viewModels()
    private val cliente:ClienteController by viewModels()
    private var dayRealiz= 0
    private var monthRealiz=0
    private var yearRealiz=0
    private var dayVenc = 0
    private var monthVenc = 0
    private var yearVenc = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FacturaActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idCliente.setOnFocusChangeListener { v, hasFocus ->
            cliente.listarClientes(binding.idCliente.text.toString())
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun fechaRealizacionDatePicker(view : View){

        when(view.id){
            R.id.buttonRealz -> {
                // Valores por defecto del DatePicker

                val now = LocalDateTime.now()
                 yearRealiz = now.year
                 monthRealiz = now.monthValue-1
                 dayRealiz = now.dayOfMonth

                val datePickerDialog = DatePickerDialog(
                    this,
                    { view, year1, monthOfYear, dayOfMonth ->
                        val dateChoice = (dayOfMonth.toString() + "-" + (monthOfYear+1) + "-" + year1)
                        binding.fechaRealz.setText(dateChoice)
                        //temp = dateChoice
                    }, yearRealiz, monthRealiz, dayRealiz
                )
                datePickerDialog.show()
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun fechaVencimientoDatePicker(view : View){
        when(view.id){
            R.id.buttonVenc -> {
                // Valores por defecto del DatePicker
                val now = LocalDateTime.now()
                 yearVenc = now.year
                 monthVenc = now.monthValue-1
                 dayVenc = now.dayOfMonth

                val datePickerDialog = DatePickerDialog(
                    this,
                    { view, year1, monthOfYear, dayOfMonth ->
                        val dateChoice = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year1)
                        binding.fechaVenc.setText(dateChoice)
                        //temp = dateChoice
                    }, yearVenc, monthVenc, dayVenc
                )
                datePickerDialog.show()
            }
        }
    }
    fun guardarFactura(view : View){
        val cliente = cliente.getClienteEncontrado()


        if(cliente != null) {
            factura.guardarFacturaInicial(
                binding.fechaRealz.text.toString(),
                binding.fechaVenc.text.toString(),
                binding.ordenCompra.text.toString(),
                binding.remision.text.toString(),
                binding.observaciones.text.toString(),
                binding.idCliente.text.toString()
            )
            val intent = Intent(this, ItemActivity::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this,"¡Cliente NO existe en la base de datos!",Toast.LENGTH_LONG).show()
        }
    }
}