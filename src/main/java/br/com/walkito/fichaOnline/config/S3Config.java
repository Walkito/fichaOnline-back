package br.com.walkito.fichaOnline.config;

import io.github.cdimascio.dotenv.Dotenv;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

public class S3Config {
    private final static String ACCESS_KEY = Dotenv.load().get("AWS_ACCESS_KEY_ID");

    private final static String SECRET_KEY = Dotenv.load().get("AWS_SECRET_ACCESS_KEY");

    private final static String AWS_REGION = Dotenv.load().get("AWS_REGION");

    private final static String SERVICE_NAME = Dotenv.load().get("AWS_SERVICE_NAME");

    private final static AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(ACCESS_KEY, SECRET_KEY);

    private final static StaticCredentialsProvider staticCredentialsProvider = StaticCredentialsProvider.create(awsBasicCredentials);
    public static S3Client s3Client = S3Client.builder()
            .region(Region.SA_EAST_1)
            .credentialsProvider(staticCredentialsProvider)
            .build();

    public S3Config(){

    }

}
