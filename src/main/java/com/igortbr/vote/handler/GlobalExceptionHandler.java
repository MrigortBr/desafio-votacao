package com.igortbr.vote.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.igortbr.vote.exception.CustomException;
import com.igortbr.vote.exception.ErrorResponse;

import jakarta.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
    	return buildResponseEntity(ex.getError());
    }
	
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
    	return buildResponseEntity(ErrorResponse.DATA_INTEGRITY);
    }
    
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(HttpMessageNotReadableException ex) {
    	return buildResponseEntity(ErrorResponse.DATA_INTEGRITY);
    }
    
    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<ErrorResponse> handleNumberFormatException(NumberFormatException ex) {
    	return buildResponseEntity(ErrorResponse.NUMBER_FORMAT);
    }
    
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNumberFormatException(NoResourceFoundException ex) {
    	return buildResponseEntity(ErrorResponse.NO_ENDPOINT);
    }
    
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleNumberFormatException(ConstraintViolationException ex) {
    	return buildResponseEntity(ErrorResponse.NOT_BLANK);
    }
    
    private ResponseEntity<ErrorResponse> buildResponseEntity(ErrorResponse response) {
        return new ResponseEntity<>(response, response.getCodeError());
    }
}
