package com.stock.manager.paymentmanagerapi.infrastructure.database.repository

import com.stock.manager.paymentmanagerapi.domain.model.items.Item
import com.stock.manager.paymentmanagerapi.domain.model.items.ItemCode
import com.stock.manager.paymentmanagerapi.domain.model.items.ItemName
import com.stock.manager.paymentmanagerapi.domain.model.manufacturers.ManufacturerCode
import com.stock.manager.paymentmanagerapi.domain.repository.ItemsRepository
import com.stock.manager.paymentmanagerapi.infrastructure.database.table.ItemsTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class ItemsRepositoryImpl : ItemsRepository {
    override fun findAll(): List<Item> {
        return transaction {
            addLogger(StdOutSqlLogger)
            ItemsTable
                .selectAll().map { toModel(it) }
                .toList()
        }
    }

    private fun toModel(result: ResultRow): Item {
        val itemCode = ItemCode(result[ItemsTable.itemCode])
        val manufacturerCode = ManufacturerCode(result[ItemsTable.manufacturerCode])
        val itemName = ItemName(result[ItemsTable.itemName])
        return Item(
            itemCode,
            manufacturerCode,
            itemName,
            result[ItemsTable.isEop]
        )
    }

    override fun register(item: Item) {
        transaction {
            addLogger(StdOutSqlLogger)
            ItemsTable.insert {
                it[itemCode] = item.itemCode.value
                it[manufacturerCode] = item.manufacturerCode.value
                it[itemName] = item.itemName.value
                it[isEop] = item.isEOP
            }
        }
    }
}