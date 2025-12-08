package com.ui.pages;

import com.ui.pojo.AddressPOJO;
import com.utilities.BrowserUtilty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BrowserUtilty {

    private static  final By  COMPANY_TEXTBOX_LOCATOR= By.id("company");
    private static final By ADDRESS1_TEXTBOX_LOCATOR= By.id("address1");
    private static final By ADDRESS2_TEXTBOX_LOCATOR= By.id("address2");
    private static final By CITY_TEXTBOX_LOCATOR =By.id("city");
    private static final By POSTCODE_TEXTBOX_LOCATOR =By.id("postcode");
    private static final By  HOMEPHONE_TEXTBOX_LOCATOR= By.id("phone");
    private static final By  MOBILEPHONE_TEXTBOX_LOCATOR= By.id("phone_mobile");
    private static final By ADDTIONAL_INFO_TEXTBOX_LOCATOR = By.id("other");
    private static final By ADDRESS_TITLE_TEXTBOX_LOCATOR = By.id("alias");
    private static final By  STATE_DROPDOWN_LOCATOR= By.xpath("//div[@id='uniform-id_state']");
    private static final By SAVE_ADDRESS_BUTTON_LOCATOR=By.id("submitAddress");

    private static final By ADDRESS_HEADING= By.xpath("//h3[@class='page-subheading']");
    //a[@title='Addresses']

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public String saveAddress(AddressPOJO addressPOJO){
        enterText(COMPANY_TEXTBOX_LOCATOR, addressPOJO.getCompany());
        enterText(ADDRESS1_TEXTBOX_LOCATOR,addressPOJO.getAddressLine1());
        enterText(ADDRESS2_TEXTBOX_LOCATOR,addressPOJO.getAddressLine2());
        enterText(CITY_TEXTBOX_LOCATOR,addressPOJO.getCity());
        selectDynamicDropdown(STATE_DROPDOWN_LOCATOR,addressPOJO.getState());
        enterText(POSTCODE_TEXTBOX_LOCATOR,addressPOJO.getPostCode());
        enterText(HOMEPHONE_TEXTBOX_LOCATOR,addressPOJO.getHomePhoneNumber());
        enterText(MOBILEPHONE_TEXTBOX_LOCATOR,addressPOJO.getMobileNumber());
        enterText(ADDTIONAL_INFO_TEXTBOX_LOCATOR,addressPOJO.getOtherInformation());
        enterText(ADDRESS_TITLE_TEXTBOX_LOCATOR,addressPOJO.getAddressAlias());
        clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);

        return getVisibleText(ADDRESS_HEADING);
    }
}
