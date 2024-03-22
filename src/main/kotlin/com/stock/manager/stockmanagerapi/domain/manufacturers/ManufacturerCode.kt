package com.stock.manager.stockmanagerapi.domain.manufacturers

data class ManufacturerCode(val value: String) {
    init {
        println("valueのエラーチェックをいれる")
    }
}
