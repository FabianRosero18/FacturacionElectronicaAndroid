package com.mycompany.facturacionelectronica.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.mycompany.facturacionelectronica.database.entities.Factura
import com.mycompany.facturacionelectronica.database.entities.Item

data class FacturaConItems(
    @Embedded val factura:Factura,
    @Relation(
        parentColumn = "id",
        entityColumn = "idFactura"
    )
    val items: List<Item>
)
