package com.mycompany.facturacionelectronica.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.mycompany.facturacionelectronica.database.entities.Cliente
import com.mycompany.facturacionelectronica.database.entities.Factura

data class ClienteConFacturas(
    @Embedded val cliente: Cliente,
    @Relation(
        parentColumn = "id",
        entityColumn = "idCliente"
    )
    val facturas: List<Factura>
)
