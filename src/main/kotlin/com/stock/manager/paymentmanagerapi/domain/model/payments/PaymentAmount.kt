package com.stock.manager.paymentmanagerapi.domain.model.payments

private const val MIN_PAYMENT_COUNT = 1L
private const val MAX_PAYMENT_COUNT = 999L

data class PaymentAmount(val value: Long) {
    init {
        if (value < MIN_PAYMENT_COUNT || value > MAX_PAYMENT_COUNT) {
            throw IllegalArgumentException("払出数量が不正です")
        }
    }
}