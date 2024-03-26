package com.stock.manager.stockmanagerapi.presentation.form

import com.fasterxml.jackson.annotation.JsonFormat
import com.stock.manager.stockmanagerapi.domain.model.items.ItemCode
import com.stock.manager.stockmanagerapi.domain.model.payments.Payment
import com.stock.manager.stockmanagerapi.domain.model.payments.PaymentAmount
import com.stock.manager.stockmanagerapi.domain.model.payments.PaymentType
import java.time.LocalDate


data class PaymentResponse(
    val paymentId: Long,
    val paymentType: PaymentType,
    val itemCode: String,
    @JsonFormat(pattern = "yyyy/MM/dd")
    val paymentDate: LocalDate,
    val paymentAmount: Long,
    val note: String?
) {
    constructor(model: Payment) : this(
        model.paymentId!!.value,
        model.paymentType,
        model.itemCode.value,
        model.paymentDate,
        model.paymentAmount.value,
        model.note
    )
}

data class RegisterPaymentRequest(
    val paymentType: PaymentType,
    val itemCode: String,
    @JsonFormat(pattern = "yyyy/MM/dd")
    val paymentDate: LocalDate,
    val paymentAmount: Long,
    val note: String?
) {
    fun toModel(): Payment {
        return Payment(
            ItemCode(this.itemCode),
            this.paymentType,
            this.paymentDate,
            PaymentAmount(this.paymentAmount),
            this.note
        )
    }
}

data class PaymentListResponse(val payments: List<PaymentResponse>)