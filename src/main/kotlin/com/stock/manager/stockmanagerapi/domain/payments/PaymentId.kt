package com.stock.manager.stockmanagerapi.domain.payments

private const val MIN_PAYMENT_ID = 1L

data class PaymentId(val value: Long) {
    init {
        if (value < MIN_PAYMENT_ID) {
            IllegalArgumentException("支払いIDが不正な値です。")
        }
    }
}