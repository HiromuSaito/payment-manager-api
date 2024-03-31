package com.stock.manager.paymentmanagerapi.presentation.controller

import com.stock.manager.paymentmanagerapi.application.service.PaymentService
import com.stock.manager.paymentmanagerapi.presentation.form.PaymentListResponse
import com.stock.manager.paymentmanagerapi.presentation.form.PaymentResponse
import com.stock.manager.paymentmanagerapi.presentation.form.RegisterPaymentRequest
import org.springframework.web.bind.annotation.*

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

    @PostMapping
    fun registerPayment(@RequestBody body: RegisterPaymentRequest) {
        paymentService.registerPayment(body.toModel())
    }
}