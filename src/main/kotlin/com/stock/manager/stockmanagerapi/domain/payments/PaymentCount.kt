package com.stock.manager.stockmanagerapi.domain.payments

private const val MIN_PAYMEN_COUNT = 1L
private const val MAX_PAYMEN_COUNT = 999L

data class PaymentCount(val value: Long) {
    init {
        if (value < MIN_PAYMEN_COUNT || value > MAX_PAYMEN_COUNT) {
            throw IllegalArgumentException("払出数量が不正です")
        }
    }
}