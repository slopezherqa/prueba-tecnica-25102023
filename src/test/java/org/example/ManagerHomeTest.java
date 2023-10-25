package org.example;

import junit.framework.Assert;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.ManagerHomePage;
import org.example.testdata.TestDataManager;
import org.example.testdata.dto.UserDTO;
import org.testng.annotations.Test;

public class ManagerHomeTest extends BaseTest{


    @Test(description = "Login and load the dashboard. (The test will fail and that is ok because one label is misprinted as Manger instead of Manager)")
    public void verifyDashboardElements (){
        UserDTO user = TestDataManager.getUserWithCorrectData();

        ManagerHomePage managerHomePage = new HomePage(driver).login(user);

        Assert.assertTrue("We are in the manager home page.", managerHomePage.managerIdLabel.isDisplayed());
        Assert.assertEquals("Manager id label is displaying the correct manager id", "Manager Id : " + user.getUserId(), managerHomePage.managerIdLabel.getText());
    }
}
