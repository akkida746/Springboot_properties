package com.example.restcontroller;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomException extends RuntimeException {

    private String message;
    private HttpStatus status = HttpStatus.OK;

    public CustomException(String message){
        super();
        this.message = message;
    }
}
