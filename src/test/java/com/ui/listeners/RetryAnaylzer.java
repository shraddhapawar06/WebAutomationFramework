package com.ui.listeners;

import com.constants.Env;
import com.utilities.JsonUtility;
import com.utilities.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnaylzer implements IRetryAnalyzer {

    //reading from properties file
    // private static final int MAX_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "MAX_ATTEMPTS"));

    //reading from json file
    private static final int MAX_ATTEMPTS= JsonUtility.readJSON(Env.QA).getMAX_ATTEMPTS();
    private static int currentAttempt = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (currentAttempt<=MAX_ATTEMPTS){
            currentAttempt++;
            return  true;
        }
        else
            return false;
    }
}
