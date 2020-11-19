package test.bucket.services

import com.amazonaws.services.s3.AmazonS3
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service

@Service
class S3Service (private val resourceLoader: ResourceLoader, private val amazonS3: AmazonS3) {
    fun getObject(bucketName: String = "s3://mybucket", key: String = "README.md") {
        println("AQUIIIIIIIIIIIIIIIIIIIIII")
        val resource  = amazonS3.getObject(bucketName, key)
        // val resource = resourceLoader.getResource("s3://$bucketName/$key")
        print(resource)
    }
}