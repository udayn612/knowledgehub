package com.stackroute.configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

/*This is the configuration class which builds the aws credentials*/
public class S3Config {

    /* The @Value annotation will bind application properties
     * directly to class fields during application initialization.
     */
    @Value("${aws.access.key.id}")
    private String awsKeyId;

    @Value("${aws.access.key.secret}")
    private String awsKeySecret;

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.s3.bucket}")
    private String awsS3AudioBucket;

    /* @Bean annotation tells that a method produces a bean
    to be managed by the Spring container.
     */
    @Bean(name = "awsKeyId")
    public String getAWSKeyId() {
        return awsKeyId;
    }

    @Bean(name = "awsKeySecret")
    public String getAWSKeySecret() {
        return awsKeySecret;
    }

    @Bean(name = "awsRegion")
    public Region getAWSPollyRegion() {
        return Region.getRegion(Regions.fromName(awsRegion));
    }



    /* A method which provides aws credentials inorder to access the
       bucket created
   */
    @Bean(name = "awsCredentialsProvider")
    public AWSCredentialsProvider getAWSCredentials() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(this.awsKeyId, this.awsKeySecret);
        return new AWSStaticCredentialsProvider(awsCredentials);
    }

    @Bean(name = "awsS3AudioBucket")
    public String getAWSS3AudioBucket() {
        return awsS3AudioBucket;
    }
}
