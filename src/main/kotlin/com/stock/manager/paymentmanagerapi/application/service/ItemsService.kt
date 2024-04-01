package com.stock.manager.paymentmanagerapi.application.service

import com.stock.manager.paymentmanagerapi.domain.model.items.Item
import com.stock.manager.paymentmanagerapi.domain.repository.ItemsRepository
import org.springframework.stereotype.Service

@Service
class ItemsService(
    val itemsRepository: ItemsRepository
) {
    fun getItemsList(): List<Item> {
        return itemsRepository.findAll()
    }

    fun register(item: Item) {
        itemsRepository.register(item)
    }
}