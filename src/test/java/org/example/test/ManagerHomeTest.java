package org.example.test;

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

        Assert.assertTrue("Manager id label is displayed.", managerHomePage.managerIdLabelButton.isDisplayed());
        Assert.assertTrue("Manager button is displayed.", managerHomePage.managerButton.isDisplayed());
        Assert.assertTrue("New customer button is displayed.", managerHomePage.newCustomerButton.isDisplayed());
        Assert.assertTrue("Edit customer button is displayed.", managerHomePage.editCustomerButton.isDisplayed());
        Assert.assertTrue("Delete customer button is displayed.", managerHomePage.deleteCustomerButton.isDisplayed());
        Assert.assertTrue("New Account button is displayed.", managerHomePage.newAccountButton.isDisplayed());
        Assert.assertTrue("Edit account button is displayed.", managerHomePage.editAccountButton.isDisplayed());
        Assert.assertTrue("Delete account button is displayed.", managerHomePage.deleteAccountButton.isDisplayed());
        Assert.assertTrue("Deposit button is displayed.", managerHomePage.depositButton.isDisplayed());
        Assert.assertTrue("Withdrawal button is displayed.", managerHomePage.withdrawalButton.isDisplayed());
        Assert.assertTrue("Fund transfer button is displayed.", managerHomePage.fundTransferButton.isDisplayed());
        Assert.assertTrue("Change password button is displayed.", managerHomePage.changePasswordButton.isDisplayed());
        Assert.assertTrue("Balance Enquiry button is displayed.", managerHomePage.balanceEnquiryButton.isDisplayed());
        Assert.assertTrue("Mini statement button is displayed.", managerHomePage.miniStatementButton.isDisplayed());
        Assert.assertTrue("Customised Statement button is displayed.", managerHomePage.customisedStatementButton.isDisplayed());
        Assert.assertTrue("Logout button is displayed.", managerHomePage.logoutButton.isDisplayed());
        Assert.assertEquals("Manager id label is displaying the correct manager id", "Manager Id : " + user.getUserId(), managerHomePage.managerIdLabelButton.getText());
        
    }
}
