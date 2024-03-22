package com.stock.manager.stockmanagerapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StockManagerApiApplication

fun main(args: Array<String>) {
	runApplication<StockManagerApiApplication>(*args)
}
