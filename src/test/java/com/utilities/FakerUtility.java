package com.utilities;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

import java.util.Locale;

public class FakerUtility {

    public static void main(String[] args) {
        getFakeAddress();
    }

    public static AddressPOJO getFakeAddress(){
        Faker faker= new Faker(Locale.US);

        AddressPOJO addressPOJO =
                new AddressPOJO(faker.company().name(),faker.address().buildingNumber(),faker.address().streetAddress(),
                        faker.address().city(), faker.address().zipCode(),faker.phoneNumber().cellPhone(),
                        faker.phoneNumber().cellPhone(),faker.lorem().sentence(5),faker.address().secondaryAddress(),faker.address().state());
        return addressPOJO;
    }


}
