package com.stock.manager.stockmanagerapi.infrastructure.database.table

import com.stock.manager.stockmanagerapi.domain.model.payments.PaymentType
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.datetime

object PaymentsTable : LongIdTable("payments") {
    val paymentType = enumerationByName("payment_type", 20, PaymentType::class)
    val itemCode = varchar("item_code", 128)
    val paymentDate = datetime("payment_date")
    val paymentAmount = long("payment_amount")
    val note = varchar("note", 400)
}
