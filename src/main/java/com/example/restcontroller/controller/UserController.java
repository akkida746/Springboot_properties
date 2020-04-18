package com.example.restcontroller.controller;

import com.example.restcontroller.CustomException;
import com.example.restcontroller.message.ResponseMessage;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource(value = "classpath:app.properties", name = "app")
@PropertySource(value = "classpath:config.properties")
public class UserController {

    @GetMapping(value = "/greeting")
    public ResponseEntity<ResponseMessage> greeting(@RequestParam String name){
        ResponseMessage message = new ResponseMessage(name);
        return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
    }

    @GetMapping(value = "/exception")
    public ResponseEntity<ResponseMessage> exception(){
        throw new CustomException("Custom Exception");
    }
}
