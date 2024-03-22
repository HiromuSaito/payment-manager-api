package com.stock.manager.stockmanagerapi.application.service

import com.stock.manager.stockmanagerapi.domain.model.payments.Payment
import com.stock.manager.stockmanagerapi.domain.repository.PaymentRepository
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val paymentRepository: PaymentRepository
) {

    fun getList(): List<Payment> {
        return paymentRepository.findAll()
    }
}