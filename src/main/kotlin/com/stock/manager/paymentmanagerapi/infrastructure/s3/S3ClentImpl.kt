package com.stock.manager.paymentmanagerapi.infrastructure.s3

import aws.sdk.kotlin.services.s3.model.PutObjectRequest
import aws.smithy.kotlin.runtime.content.asByteStream
import aws.smithy.kotlin.runtime.net.url.Url
import com.stock.manager.paymentmanagerapi.domain.s3.S3Client
import org.springframework.stereotype.Component
import java.io.File

@Component
class S3ClentImpl : S3Client {
    override suspend fun putObjects(file: File) {
        val request = PutObjectRequest {
            bucket = "payment-manager-qr-bucket"
            key = file.name
            body = file.asByteStream()
        }
        aws.sdk.kotlin.services.s3.S3Client.fromEnvironment {
            region = "ap-northeast-1"
            endpointUrl = Url.parse("http://127.0.0.1:4566")
        }.use { s3 ->
            val res = s3.putObject(request)
        }
    }
}