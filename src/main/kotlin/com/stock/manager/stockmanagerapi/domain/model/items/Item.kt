package com.stock.manager.stockmanagerapi.domain.model.items

import com.stock.manager.stockmanagerapi.domain.model.manufacturers.ManufacturerCode

data class Item(
    val itemCode: ItemCode,
    val manufacturerCode: ManufacturerCode,
    val itemName: ItemName,
    val isEOP: Boolean
)