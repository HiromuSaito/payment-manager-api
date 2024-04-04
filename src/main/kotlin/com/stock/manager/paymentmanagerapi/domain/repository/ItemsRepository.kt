package com.stock.manager.paymentmanagerapi.domain.repository

import com.stock.manager.paymentmanagerapi.domain.model.items.Item

interface ItemsRepository {

    fun find(itemCode: String): Item?
    fun findAll(): List<Item>
    fun register(item: Item)
}