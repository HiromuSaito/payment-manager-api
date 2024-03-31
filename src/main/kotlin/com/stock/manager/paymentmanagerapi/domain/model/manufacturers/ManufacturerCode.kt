package com.stock.manager.paymentmanagerapi.domain.model.manufacturers

data class ManufacturerCode(val value: String) {
    init {
        println("valueのエラーチェックをいれる")
    }
}
