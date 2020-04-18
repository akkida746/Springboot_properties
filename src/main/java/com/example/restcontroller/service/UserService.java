package com.example.restcontroller.service;

import com.example.restcontroller.CustomException;
import com.example.restcontroller.entity.AppDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class UserService {
    @Value("${developer.name}")
    private String developerName;

    @Autowired
    private ConfigService configService;

    @Autowired
    private ObjectMapper jsonObjectMapper;

    public String getAppName(){
        AppDetails appProperties = null;
        Map<String, String> map = configService.getAppProperties();
        try {
            appProperties = jsonObjectMapper.readValue(map.get("app.details"), AppDetails.class);
        } catch (JsonProcessingException e) {
            log.error("Error while parsing json");
        }
        if(Objects.isNull(appProperties)){
            throw new CustomException("App properties not found error!");
        }
        return appProperties.getAppName();
    }

    public String getDeveloperName(){
        AppDetails appProperties = null;
        Map<String, String> map = configService.getAppProperties();
        try {
            appProperties = jsonObjectMapper.readValue(map.get("app.details"), AppDetails.class);
        } catch (JsonProcessingException e) {
            log.error("Error while parsing json");
        }
        if(Objects.isNull(appProperties)){
            throw new CustomException("App properties not found error!");
        }
        return appProperties.getDeveloper();
    }

    public String getDeveloperNameFromProperties(){
        return developerName;
    }
}
