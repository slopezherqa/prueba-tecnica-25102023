package org.example.testdata;

import org.example.testdata.dto.UserDTO;

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

}
