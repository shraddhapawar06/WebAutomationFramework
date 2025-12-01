package com.utilities;

import com.constants.Browser;
import com.constants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public abstract class PropertiesUtil {

    //read properties file

    public static String readProperty(Env env, String keyName){
        System.out.println(System.getProperty("user.dir"));

        File propFile = new File(System.getProperty("user.dir") +"//config//"+ env+".properties");
        FileReader fileReader= null;
        Properties properties =new Properties();
        try {
            fileReader = new FileReader(propFile);
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value= properties.getProperty(keyName.toUpperCase());
       return value;

    }
}
