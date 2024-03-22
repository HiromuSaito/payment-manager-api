package com.stock.manager.stockmanagerapi.domain.payments

import com.stock.manager.stockmanagerapi.domain.items.ItemCode
import java.time.LocalDate

data class Payment(
    val paymentId: PaymentId?,
    val paymentType: PaymentType,
    val itemCode: ItemCode,
    val paymentDate: LocalDate,
    val paymentCount: PaymentCount,
    val note: String?
) {
    constructor(
        itemCode: ItemCode,
        paymentType: PaymentType,
        paymentDate: LocalDate,
        paymentCount: PaymentCount,
        note: String?
    ) : this(null, paymentType, itemCode, paymentDate, paymentCount, note)
}
