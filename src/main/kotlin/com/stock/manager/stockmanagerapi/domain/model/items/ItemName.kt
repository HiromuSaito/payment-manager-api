package com.stock.manager.stockmanagerapi.domain.model.items

private const val MAX_NAME_LENGTH = 200

data class ItemName(val value: String) {
    init {
        if (value.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("商品名は${MAX_NAME_LENGTH}字以内のみ許容されています。")
        }
    }
}