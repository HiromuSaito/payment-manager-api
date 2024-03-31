package com.stock.manager.paymentmanagerapi.domain.model.items

import com.stock.manager.paymentmanagerapi.domain.model.manufacturers.ManufacturerCode

data class Item(
    val itemCode: ItemCode,
    val manufacturerCode: ManufacturerCode,
    val itemName: ItemName,
    val isEOP: Boolean
)