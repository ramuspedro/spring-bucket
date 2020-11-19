package test.bucket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BucketApplication

fun main(args: Array<String>) {
	runApplication<BucketApplication>(*args)
}
