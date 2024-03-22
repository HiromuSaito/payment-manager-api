package com.stock.manager.stockmanagerapi.domain.items

import com.stock.manager.stockmanagerapi.domain.manufacturers.ManufacturerCode

data class Item(
    val itemCode: ItemCode,
    val manufacturerCode: ManufacturerCode,
    val itemName: ItemName,
    val isEOP: Boolean
)