package org.example.testdata;

import org.example.testdata.dto.UserDTO;

import java.util.Random;

public class TestDataManager {


    public static UserDTO getUserWithCorrectData(){
        return new UserDTO()
                .withUserId("mngr534520")
                .withUserEmail("test_email@email.com")
                .withUserPassword("gAhAheq");
    }

    public static UserDTO getUserWithIncorrectPassword(){
        return getUserWithCorrectData().withUserPassword("saudhsad");
    }

    public static UserDTO getUserWithIncorrectUserId(){
        return getUserWithCorrectData().withUserId("mngr534232");
    }


    public static String getRandomEmail(){
        int randomInteger = new Random().nextInt(10000);
        return "randomemail" + randomInteger + "@mail.com";
    }

}
