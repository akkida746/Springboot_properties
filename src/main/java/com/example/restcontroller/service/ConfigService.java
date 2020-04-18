package com.example.restcontroller.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class ConfigService {

    @Autowired
    private Environment environment;

    private Map<String,String> appPropertiesMap = new HashMap<>();

    @PostConstruct
    @Cacheable(value = "app_properties")
    public Map<String,String> getAppProperties(){
        if(environment instanceof ConfigurableEnvironment){
            AbstractEnvironment abs = (AbstractEnvironment) environment;
            PropertySource propertySource = abs.getPropertySources().get("app");
            Properties properties = (Properties) propertySource.getSource();

            for(Object key: properties.keySet()){
                appPropertiesMap.put(key.toString(), properties.get(key).toString());
            }
        }

        return appPropertiesMap;
    }
}
