package test.bucket.entity

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@ConfigurationProperties(prefix = "amazon-properties")
@Configuration
class AmazonConfig {
    lateinit var configs:Secret

    @Bean
    fun S3(): AmazonS3? {
        val awsCredentials: AWSCredentials = BasicAWSCredentials(
                "ACCESSKEYAWSUSER",
                "sEcreTKey"
        )

        val endpoint = AwsClientBuilder.EndpointConfiguration("http://localhost:4566", "us-west-2")
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
                .withEndpointConfiguration(endpoint)
                .build()
    }
}

class Secret {
    lateinit var endpointUrl: String
    lateinit var accessKey: String
    lateinit var secretKey: String
    lateinit var bucketName: String
}