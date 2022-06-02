package com.example.attendanceautomationspring.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

;

@Component
@Configuration
@PropertySource("classpath:application.properties")
public class ReadFromPropertiesFile {


    public String getPropertyKeyVariable() {
        return propertyKeyVariable;
    }

    public void setPropertyKeyVariable(String propertyKeyVariable) {
        this.propertyKeyVariable = propertyKeyVariable;
    }


    @Value("${spring.config.import}")
    private String propertyKeyVariable;




    @Value("${spring.app.nidNo}")
    private String appNidNo;

    private String anotherVar;

    @PostConstruct
    public String postConstruct(){

       return appNidNo; // <-- using myVar after the bean construction
    }



}
