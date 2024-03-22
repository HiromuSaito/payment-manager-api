package com.stock.manager.stockmanagerapi.domain.manufacturers

private const val MAX_NAME_LENGTH = 100

data class ManufacturerName(val value: String) {
    init {
        if (value.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("メーカー名は${MAX_NAME_LENGTH}字以内のみ許容されています。")
        }
    }
}