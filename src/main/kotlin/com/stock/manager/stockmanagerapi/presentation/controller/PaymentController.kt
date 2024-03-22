package com.stock.manager.stockmanagerapi.presentation.controller

import com.stock.manager.stockmanagerapi.application.service.PaymentService
import com.stock.manager.stockmanagerapi.presentation.form.PaymentListResponse
import com.stock.manager.stockmanagerapi.presentation.form.PaymentResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/payments")
class PaymentController(
    private val paymentService: PaymentService
) {
    @GetMapping
    fun getPaymentsList(): PaymentListResponse {
        val list = paymentService.getList().map { PaymentResponse(it) }
        return PaymentListResponse(list)
    }
}