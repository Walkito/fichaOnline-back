package br.com.walkito.fichaOnline.service;

import br.com.walkito.fichaOnline.config.S3Config;
import br.com.walkito.fichaOnline.model.dtos.ImageDTO;
import br.com.walkito.fichaOnline.service.exception.ExceptionConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;

@Service
public class FileService {
    private final String BUCKET = "imagensfichaonline";

    public ResponseEntity<Object> uploadFile(ImageDTO image, String folder) {
        try {
            RequestBody requestBody = transformFile(image);
            PutObjectRequest request = buildPut(folder + "/" + image.getFileName());
            S3Config.s3Client.putObject(request, requestBody);

            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    public ResponseEntity<Object> downloadFile(String folder, String fileName) {
        try {
            GetObjectRequest request = buildGet(folder + "/" + fileName);
            ResponseInputStream<GetObjectResponse> response = S3Config.s3Client.getObject(request);

            byte[] contentBytes = response.readAllBytes();

            HttpHeaders headers = buildHeader();

            return new ResponseEntity<>(contentBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ExceptionConstructor().responseConstructor(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }

    private byte[] decodeBase64(String imageInBase64){
        return Base64.getMimeDecoder().decode(imageInBase64);
    }

    private RequestBody transformFile(ImageDTO image){
        ByteBuffer byteBuffer = ByteBuffer.wrap(decodeBase64(image.getImageB64()));
        return RequestBody.fromByteBuffer(byteBuffer);
    }

    private PutObjectRequest buildPut(String fileName){
        return PutObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();
    }

    private GetObjectRequest buildGet(String fileName){
        return GetObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();
    }

    private HttpHeaders buildHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return headers;
    }
}
