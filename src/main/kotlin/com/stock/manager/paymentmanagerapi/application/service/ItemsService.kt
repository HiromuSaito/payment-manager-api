package com.stock.manager.paymentmanagerapi.application.service

import com.stock.manager.paymentmanagerapi.domain.model.items.Item
import com.stock.manager.paymentmanagerapi.domain.model.items.ItemCode
import com.stock.manager.paymentmanagerapi.domain.repository.ItemsRepository
import com.stock.manager.paymentmanagerapi.domain.s3.S3Client
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

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

    fun getItemQr(itemCode: ItemCode): String {
        val path = Paths.get(itemCode.value)
        runBlocking {
            s3Client.downloadObject("${itemCode.value}.png", path)
        }
        return getBase64(path)
    }

    private fun getBase64(path: Path): String {
        val file = path.toFile()

        val contentType = Files.probeContentType(file.toPath())
        val data = Files.readAllBytes(file.toPath())
        val base64str = Base64.getEncoder().encodeToString(data)

        val sb = StringBuilder()
        sb.append("data:")
        sb.append(contentType)
        sb.append(";base64,")
        sb.append(base64str)
        return sb.toString()
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