package com.stock.manager.paymentmanagerapi.domain.repository

import com.stock.manager.paymentmanagerapi.domain.model.payments.Payment

interface PaymentRepository {
    fun findAll(): List<Payment>
    fun register(payment: Payment)
}