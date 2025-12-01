package com.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {



    private LoggerUtility(){
    }
    public static Logger getLogger(Class<?> clazz){
        Logger logger=null;
        System.out.println("Inside loggerUtility");
        if(logger == null){
            logger= LogManager.getLogger(clazz);
        }
        return logger;
    }
}
