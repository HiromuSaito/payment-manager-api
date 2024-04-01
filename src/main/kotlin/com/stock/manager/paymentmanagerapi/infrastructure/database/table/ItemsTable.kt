package com.stock.manager.paymentmanagerapi.infrastructure.database.table

import org.jetbrains.exposed.sql.Table

object ItemsTable:Table("items"){
    val itemCode = varchar("item_code",200)
    val manufacturerCode = varchar("manufacturer_code",128)
    val itemName = varchar("item_name",200)
    val isEop = bool("is_eop")
    override val primaryKey = PrimaryKey(itemCode)
}