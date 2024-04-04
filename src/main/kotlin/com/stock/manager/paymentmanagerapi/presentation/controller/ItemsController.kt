package com.stock.manager.paymentmanagerapi.presentation.controller

import com.stock.manager.paymentmanagerapi.application.service.ItemsService
import com.stock.manager.paymentmanagerapi.domain.model.items.ItemCode
import com.stock.manager.paymentmanagerapi.domain.s3.S3Client
import com.stock.manager.paymentmanagerapi.presentation.form.ItemCodeListResponse
import com.stock.manager.paymentmanagerapi.presentation.form.ItemListResponse
import com.stock.manager.paymentmanagerapi.presentation.form.ItemRegisterRequest
import com.stock.manager.paymentmanagerapi.presentation.form.ItemResponse
import jakarta.servlet.http.HttpServletResponse
import org.springframework.core.io.PathResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.io.BufferedOutputStream
import java.nio.file.Files
import java.nio.file.Path


@RestController
@RequestMapping("/api/items")
class ItemsController(
    val itemsService: ItemsService,
    val s3Client: S3Client
) {

    @GetMapping
    fun getItemsList(): ItemListResponse {
        val items = itemsService.getItemsList().map { ItemResponse(it) }
        return ItemListResponse(items)
    }

    @GetMapping("/{id}")
    fun getItem(@PathVariable itemCode: String): ItemResponse {
        return ItemResponse(itemsService.getItem(itemCode))
    }

    @PostMapping
    fun registerItem(@RequestBody body: ItemRegisterRequest) {
        itemsService.register(body.toModel())
    }

    @GetMapping("/codes")
    fun getItemCodeList(): ItemCodeListResponse {
        val itemCodeList = itemsService.getItemsList().map { it.itemCode.value }
        return ItemCodeListResponse(itemCodeList)
    }

    @GetMapping("/qr/{id}")
    fun downloadQRImg(@PathVariable id: String, response: HttpServletResponse) {
        itemsService.downloadQR(ItemCode(id))
        val path = Path.of("$id.png")
        val resource = PathResource(path)

        response.contentType = MediaType.IMAGE_PNG.toString()
        response.setContentLengthLong(resource.contentLength())
        response.setHeader(
            HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + resource.filename + "\""
        )
        BufferedOutputStream(response.outputStream).use { out ->
            out.write(resource.contentAsByteArray)
        }

        Files.delete(path)
    }
}