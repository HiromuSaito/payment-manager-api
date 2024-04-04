package com.stock.manager.paymentmanagerapi.presentation.controller

import com.stock.manager.paymentmanagerapi.application.service.ItemsService
import com.stock.manager.paymentmanagerapi.domain.model.items.ItemCode
import com.stock.manager.paymentmanagerapi.presentation.form.ItemCodeListResponse
import com.stock.manager.paymentmanagerapi.presentation.form.ItemListResponse
import com.stock.manager.paymentmanagerapi.presentation.form.ItemRegisterRequest
import com.stock.manager.paymentmanagerapi.presentation.form.ItemResponse
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/items")
class ItemsController(
    val itemsService: ItemsService
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
    fun download(@PathVariable id: String): String {
        return itemsService.getItemQr(ItemCode(id))
    }
}