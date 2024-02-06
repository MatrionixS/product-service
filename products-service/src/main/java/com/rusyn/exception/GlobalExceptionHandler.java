package com.rusyn.exception;

import com.rusyn.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ProductNotFoundException.class, ProductAlreadyExistsException.class, CategoryNotFoundException.class})
    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception exception,
                                                                   WebRequest request) {
        ErrorDto errorDto = new ErrorDto(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
