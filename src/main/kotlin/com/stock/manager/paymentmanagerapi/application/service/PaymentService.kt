package com.stock.manager.paymentmanagerapi.application.service

import com.stock.manager.paymentmanagerapi.domain.model.payments.Payment
import com.stock.manager.paymentmanagerapi.domain.repository.PaymentRepository
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val paymentRepository: PaymentRepository
) {

    fun getList(): List<Payment> {
        return paymentRepository.findAll()
    }

    fun registerPayment(payment: Payment) {
        paymentRepository.register(payment)
    }
}