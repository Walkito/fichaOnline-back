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
import software.amazon.awssdk.services.s3.model.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

@Service
public class FileService {
    private final String BUCKET = "imagensfichaonline";

    public ResponseEntity<Object> uploadFile(String olderFileName, String folder, ImageDTO image) {
        try {
            if (checkExistingFile(folder, image.getFileName())) {
                return new ResponseEntity<>(false, HttpStatus.OK);
            }

            if (!deleteFile(folder, olderFileName)){
                return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
            }

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

    private boolean deleteFile(String folder, String fileName) {
        try{
            DeleteObjectRequest request = buildDelete(folder + "/" + fileName);
            S3Config.s3Client.deleteObject(request);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private byte[] decodeBase64(String imageInBase64) {
        return Base64.getMimeDecoder().decode(imageInBase64);
    }

    private RequestBody transformFile(ImageDTO image) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(decodeBase64(image.getImageB64()));
        return RequestBody.fromByteBuffer(byteBuffer);
    }

    private DeleteObjectRequest buildDelete(String fileName){
        return DeleteObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();
    }

    private PutObjectRequest buildPut(String fileName) {
        return PutObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();
    }

    private GetObjectRequest buildGet(String fileName) {
        return GetObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();
    }

    private HttpHeaders buildHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return headers;
    }

    public boolean checkExistingFile(String folder, String fileName) {
        ResponseEntity<Object> obj = downloadFile(folder, fileName);
        return obj.getStatusCode() == HttpStatus.OK;
    }
}
