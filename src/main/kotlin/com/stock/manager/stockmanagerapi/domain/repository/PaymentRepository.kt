package com.stock.manager.stockmanagerapi.domain.repository

import com.stock.manager.stockmanagerapi.domain.model.payments.Payment

interface PaymentRepository {
    fun findAll(): List<Payment>
}