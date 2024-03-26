package com.stock.manager.stockmanagerapi.infrastructure.database.repository

import com.stock.manager.stockmanagerapi.domain.model.items.ItemCode
import com.stock.manager.stockmanagerapi.domain.model.payments.Payment
import com.stock.manager.stockmanagerapi.domain.model.payments.PaymentAmount
import com.stock.manager.stockmanagerapi.domain.model.payments.PaymentId
import com.stock.manager.stockmanagerapi.domain.repository.PaymentRepository
import com.stock.manager.stockmanagerapi.infrastructure.database.table.PaymentsTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class PaymentRepositoryImpl : PaymentRepository {
    override fun findAll(): List<Payment> {
        return transaction {
            addLogger(StdOutSqlLogger)
            PaymentsTable
                .selectAll().map { toModel(it) }
                .toList()
        }
    }

    override fun register(payment: Payment) {
        transaction {
            addLogger(StdOutSqlLogger)
            PaymentsTable.insert {
                it[paymentType] = payment.paymentType
                it[itemCode] = payment.itemCode.value
                it[paymentDate] = payment.paymentDate.atStartOfDay()
                it[paymentAmount] = payment.paymentAmount.value
                it[note] = payment.note
            }
        }
    }

    private fun toModel(result: ResultRow): Payment {
        val id = PaymentId(result[PaymentsTable.id].value)
        val itemCode = ItemCode(result[PaymentsTable.itemCode])
        val paymentAmount = PaymentAmount(result[PaymentsTable.paymentAmount])
        return Payment(
            id,
            result[PaymentsTable.paymentType],
            itemCode,
            result[PaymentsTable.paymentDate].toLocalDate(),
            paymentAmount,
            result[PaymentsTable.note],
        )
    }
}