package com.aidiph.api.aidiph_payroll_service.exception;

import com.aidiph.api.aidiph_payroll_service.dto.Response.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> badRequestConstraintViolationException(ConstraintViolationException ex) {
        return getErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> badRequestMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + " : " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(" , "));
        return getErrorResponse(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return getErrorResponse(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> resourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
        return getErrorResponse(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> invalidInputException(InvalidInputException invalidInputException){
        return getErrorResponse(invalidInputException.getMessage(), HttpStatus.BAD_REQUEST );
    }

    private ResponseEntity<ErrorResponse> getErrorResponse(String errorMessage, HttpStatus status) {
        log.error("Internal error: {}", errorMessage);
        ErrorResponse errorResponse = new ErrorResponse(status.name(),errorMessage, status.value());
        return ResponseEntity.status(status).body(errorResponse);
    }
}
