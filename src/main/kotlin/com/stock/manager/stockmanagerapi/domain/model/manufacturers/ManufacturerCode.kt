package com.stock.manager.stockmanagerapi.domain.model.manufacturers

data class ManufacturerCode(val value: String) {
    init {
        println("valueのエラーチェックをいれる")
    }
}
