package com.stock.manager.paymentmanagerapi.domain.s3

import java.io.File

interface S3Client {
    suspend fun putObjects(file: File)
}