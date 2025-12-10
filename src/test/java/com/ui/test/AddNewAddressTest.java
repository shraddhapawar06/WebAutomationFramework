package com.ui.test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utilities.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ com.ui.listeners.TestListener.class })

public class AddNewAddressTest extends TestBase{

    private MyAccountPage myAccountPage;
    private AddressPage addressPage;
    private AddressPOJO addressPOJO;

    @BeforeMethod(description = "Valid user logged into application")
    public void setUp(){
        myAccountPage=homePage.goToLoginPage().doLoginWith("sigoro5941@foxroids.com","password");
        addressPOJO = FakerUtility.getFakeAddress();
    }

    @Test(description = "Verify add new address functionality",
            groups = {"e2e","smoke","sanity"})
    public void addAddress(){
         String newAddress= myAccountPage.goToAddressPage().saveAddress(addressPOJO);
        Assert.assertEquals(newAddress,addressPOJO.getAddressAlias().toUpperCase());
    }


}
