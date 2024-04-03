package com.stock.manager.paymentmanagerapi.application.service

import com.stock.manager.paymentmanagerapi.domain.model.items.Item
import com.stock.manager.paymentmanagerapi.domain.repository.ItemsRepository
import com.stock.manager.paymentmanagerapi.domain.s3.S3Client
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class ItemsService(
    val itemsRepository: ItemsRepository,
    val qrService: QRService,
    val s3Client: S3Client
) {

    fun getItem(itemCode: String): Item {
        return itemsRepository.find(itemCode)
            ?: throw IllegalArgumentException("存在しない商品コードです。商品コード=$itemCode")
    }

    fun getItemsList(): List<Item> {
        return itemsRepository.findAll()
    }

    fun register(item: Item) {
        val qr = qrService.createQR(item.itemCode.value)

        runBlocking {
            s3Client.putObjects(qr)
            qr.delete()
        }
        itemsRepository.register(item)
    }
}