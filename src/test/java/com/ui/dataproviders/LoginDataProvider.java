package com.ui.dataproviders;

import com.google.gson.Gson;
import com.ui.pojo.User;
import com.ui.pojo.UserData;
import com.utilities.CSVReaderUtility;
import com.utilities.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDatProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        File testdataFile = new File(System.getProperty("user.dir") + "//TestData//Logindata.json");
        FileReader fileReader = new FileReader(testdataFile);
        UserData userData = gson.fromJson(fileReader, UserData.class);

        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        for (User user : userData.getData()) {

            dataToReturn.add(new Object[]{user});

        }
        return dataToReturn.iterator();
    }

    @DataProvider(name = "LoginCSVDataProvider")
    public Iterator<User> loginCSVDataProvider() {
        return CSVReaderUtility.readCSVFile("LoginData");
    }


    @DataProvider(name = "LoginExcelDataProvider")
    public Iterator<User> LoginExcelDataProvider() {
        return ExcelReaderUtility.readExcelFile("LoginData.xlsx");


    }
}