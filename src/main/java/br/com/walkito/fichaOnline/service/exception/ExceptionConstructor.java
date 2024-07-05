package br.com.walkito.fichaOnline.service.exception;

import br.com.walkito.fichaOnline.model.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionConstructor {
    public ResponseEntity<Object> responseConstructor(HttpStatus status, String message, String details){
        CustomError response = new CustomError(status.value(), message, details);
        return new ResponseEntity<>(response, status);
    }
}
