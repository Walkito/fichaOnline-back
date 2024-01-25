package br.com.walkito.fichaOnline.config;

public class S3Config {

    public final static String ACCESS_KEY = System.getenv("AWS_ACCESS_KEY_ID");

    public final static String SECRET_KEY = System.getenv("AWS_SECRET_ACCESS_KEY");

    public final static String AWS_REGION = System.getenv("AWS_REGION");

    public final static String SERVICE_NAME = System.getenv("AWS_SERVICE_NAME");
}
