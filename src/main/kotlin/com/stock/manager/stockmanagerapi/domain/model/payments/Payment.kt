package com.stock.manager.stockmanagerapi.domain.model.payments

import com.stock.manager.stockmanagerapi.domain.model.items.ItemCode
import java.time.LocalDate

data class Payment(
    val paymentId: PaymentId?,
    val paymentType: PaymentType,
    val itemCode: ItemCode,
    val paymentDate: LocalDate,
    val paymentAmount: PaymentAmount,
    val note: String?
) {
    constructor(
        itemCode: ItemCode,
        paymentType: PaymentType,
        paymentDate: LocalDate,
        paymentAmount: PaymentAmount,
        note: String?
    ) : this(null, paymentType, itemCode, paymentDate, paymentAmount, note)
}
