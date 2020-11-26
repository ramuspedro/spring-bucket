package test.bucket.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import test.bucket.services.AmazonClient


@RestController
@RequestMapping("storage")
class BucketController () {
    private var amazonClient: AmazonClient? = null

    @Autowired
    fun BucketController(amazonClient: AmazonClient?) {
        this.amazonClient = amazonClient
    }

    @PostMapping("/uploadFile")
    fun uploadFile(@RequestPart(value = "file") file: MultipartFile): String? {
        return amazonClient!!.uploadFile(file)
    }

    @DeleteMapping("/deleteFile")
    fun deleteFile(@RequestPart(value = "url") fileUrl: String): String? {
        return amazonClient!!.deleteFileFromS3Bucket(fileUrl)
    }

    @GetMapping
    fun read(): ResponseEntity<String> {
        return ResponseEntity.ok("Hellloooooooo")
    }
}