package com.example.restcontroller.message;

import lombok.Data;

@Data
public class ResponseMessage {

    private String message;
    public ResponseMessage(String message){
        this.message = message;
    }
}
