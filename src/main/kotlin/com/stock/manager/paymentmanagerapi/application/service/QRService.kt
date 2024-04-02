package com.stock.manager.paymentmanagerapi.application.service

import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import org.springframework.stereotype.Service
import java.io.File
import java.util.*
import javax.imageio.ImageIO

private const val QR_WIDTH_SIZE = 160
private const val QR_HEIGHT_SIZE = 100

@Service
class QRService {

    fun createQR(contents: String): File {
        val format = BarcodeFormat.QR_CODE

        val hints = Hashtable<EncodeHintType, ErrorCorrectionLevel>()
        hints[EncodeHintType.ERROR_CORRECTION] = ErrorCorrectionLevel.M

        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(contents, format, QR_WIDTH_SIZE, QR_HEIGHT_SIZE, hints)
        val image = MatrixToImageWriter.toBufferedImage(bitMatrix)
        val output = File("$contents.png")
        ImageIO.write(image, "png", output)
        return output
    }
}