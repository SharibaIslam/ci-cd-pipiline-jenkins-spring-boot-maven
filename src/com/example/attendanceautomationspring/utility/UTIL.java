package com.example.attendanceautomationspring.utility;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class UTIL {

    public Properties readPropData() throws IOException {
        Properties prop=new Properties();
        InputStream inputSteam=null;
        try {
            String propFileName = "application.properties";
            inputSteam = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputSteam != null) {
                prop.load(inputSteam);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        }catch(Exception e){
            System.out.println("Exception: " + e);
        }finally {
            inputSteam.close();
        }
        return prop;
    }

    public static String generateRandomUUID(){
        String FirstThrreeDigit="476c01c0-1013-4eb4-bd2d-d6f050d";
        String phoneNumber =FirstThrreeDigit+ RandomStringUtils.randomNumeric(5);
        return phoneNumber;
    }

    public static String generateRandomDeviceUD(){
        String FirstThrreeDigit="7df71c20193";
        String phoneNumber =FirstThrreeDigit+ RandomStringUtils.randomNumeric(5);
        return phoneNumber;
    }
    public static String generateRandomRequestId(){
        String FirstThrreeDigit="tusi22";
        String phoneNumber =FirstThrreeDigit+ RandomStringUtils.randomNumeric(7);
        return phoneNumber;
    }
    public static String generateRandomMobileNumber(){
        String operatorCode = "0160";
        String phoneNumber = operatorCode + RandomStringUtils.randomNumeric(7);
        return phoneNumber;
    }

    public Properties fetchProperties(){
        Properties properties = new Properties();
        try {
            File file = ResourceUtils.getFile("classpath:testng.xml");
            InputStream in = new FileInputStream(file);
            properties.load(in);
        } catch (IOException e) {
            System.out.println(e);
        }
        return properties;
    }

    public File getResourceFile(final String fileName)
    {
        URL url = this.getClass()
                .getClassLoader()
                .getResource(fileName);

        if(url == null) {
            throw new IllegalArgumentException(fileName + " is not found 1");
        }

        File file = new File(url.getFile());

        return file;
    }
}
