package com.rio.userAuth.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
  @ExceptionHandler(Exception.class)
    public  ResponseEntity<String> validationError(MethodArgumentNotValidException e){
      final String[] ans = {""};
    e.getBindingResult().getAllErrors().forEach((error)->{

         String fieldName1 = ((FieldError)error).getField();

         String message=error.getDefaultMessage();
            ans[0] +=fieldName1+": "+message+"\n";

    });
      return new ResponseEntity<>(ans[0],HttpStatus.NOT_FOUND);  }

}
