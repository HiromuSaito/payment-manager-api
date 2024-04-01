package com.stock.manager.paymentmanagerapi.presentation.form

import com.stock.manager.paymentmanagerapi.domain.model.items.Item
import com.stock.manager.paymentmanagerapi.domain.model.items.ItemCode
import com.stock.manager.paymentmanagerapi.domain.model.items.ItemName
import com.stock.manager.paymentmanagerapi.domain.model.manufacturers.ManufacturerCode


class ItemResponse(
    val itemCode: String,
    val manufacturerCode: String,
    val itemName: String,
    val isEOP: Boolean
) {
    constructor(model: Item) : this(
        model.itemCode.value,
        model.manufacturerCode.value,
        model.itemName.value,
        model.isEOP
    )
}

class ItemListResponse(val items: List<ItemResponse>)

data class ItemRegisterRequest(
    val itemCode: String,
    val manufacturerCode: String,
    val itemName: String,
    val isEOP: Boolean
) {
    fun toModel(): Item {
        return Item(
            ItemCode(this.itemCode),
            ManufacturerCode(this.manufacturerCode),
            ItemName(this.itemName),
            this.isEOP
        )
    }
}

class ItemCodeListResponse(val itemCodes: List<String>)
