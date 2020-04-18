package com.example.restcontroller.advice;

import com.example.restcontroller.CustomException;
import com.example.restcontroller.message.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ResponseMessage> handle(CustomException ex){
        log.info("Inside Exception Handler..");
        ResponseMessage message = new ResponseMessage(ex.getMessage());
        return new ResponseEntity<ResponseMessage>(message, ex.getStatus());
    }
}
