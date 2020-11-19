package test.bucket.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import test.bucket.services.S3KeyDoesNotExistException
import test.bucket.services.S3Service
import javax.swing.text.html.parser.Entity

@RestController
@RequestMapping("storage")
class BucketController (private val service: S3Service) {
    @GetMapping
    fun read(): ResponseEntity.BodyBuilder {

        val s3Object = service.getObject()
        return ResponseEntity.status(200)

    }
}