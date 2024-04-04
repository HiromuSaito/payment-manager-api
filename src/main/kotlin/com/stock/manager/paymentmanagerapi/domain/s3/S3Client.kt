package com.stock.manager.paymentmanagerapi.domain.s3

import java.io.File
import java.nio.file.Path

interface S3Client {
    suspend fun putObjects(file: File)

    suspend fun downloadObject(key: String, path: Path)
}