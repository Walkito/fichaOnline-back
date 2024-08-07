package br.com.walkito.fichaOnline.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class MethodArgumentoException extends ExceptionConstructor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        HttpStatus errorStatus = HttpStatus.BAD_REQUEST;
        String errorMessage = "Erro de validação!";
        StringBuilder errorDetails = new StringBuilder();
        List<FieldError> errorsList = ex.getBindingResult().getFieldErrors();

        for (FieldError error : errorsList){
            errorDetails.append(error.getField() + " " + error.getDefaultMessage() + ", ");
        }

        return responseConstructor(errorStatus, errorMessage, errorDetails.toString());
    }
}
