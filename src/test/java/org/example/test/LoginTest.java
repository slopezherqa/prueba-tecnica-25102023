package org.example.test;

import junit.framework.Assert;
import org.example.testdata.TestDataManager;
import org.example.testdata.dto.UserDTO;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.ManagerHomePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import org.testng.annotations.Test;



public class LoginTest extends BaseTest{

    @Test(description = "Elements of Login Page are visible.")
    public void allElementsDisplayed(){
        HomePage homePage = new HomePage(driver);

        Assert.assertEquals("Page title is Correct", "Guru99 Bank Home Page", driver.getTitle());
        Assert.assertEquals("Login title is correct", "Guru99 Bank", homePage.formLoginTitle.getText());
        Assert.assertTrue("The login Button is Displayed", homePage.btnLogin.isDisplayed());
        Assert.assertTrue("The reset Button is Displayed", homePage.btnReset.isDisplayed());
    }

    @Test(description = "Check that the reset button is working.")
    public void resetButtonIsWorking() {
        HomePage homePage = new HomePage(driver);

        String userId = "slajdpasjd";
        String password = "lsadlasndk";

        homePage.enterUserId(userId);
        homePage.enterPassword(password);

        Assert.assertEquals("User Id text field is filled with the information given", userId, homePage.getTextFieldValue(homePage.userIdTextField));
        Assert.assertEquals("Password text field is filled with the information given", password, homePage.getTextFieldValue(homePage.passwordTextField));

        homePage.clickResetButton();

        Assert.assertTrue("User Id text field is empty", homePage.getTextFieldValue(homePage.userIdTextField).isEmpty());
        Assert.assertTrue("Password text field is empty", homePage.getTextFieldValue(homePage.passwordTextField).isEmpty());
    }


    @Test(description = "Login to the application.")
    public void loginWithCorrectData(){
        UserDTO user = TestDataManager.getUserWithCorrectData();

        HomePage homePage = new HomePage(driver);

        homePage.enterUserId(user.getUserId());
        homePage.enterPassword(user.getUserPassword());

        Assert.assertEquals("User Id text field is filled with the information given", user.getUserId(), homePage.getTextFieldValue(homePage.userIdTextField));
        Assert.assertEquals("Password text field is filled with the information given", user.getUserPassword(), homePage.getTextFieldValue(homePage.passwordTextField));

        homePage.clickLoginButton();

        ManagerHomePage managerHomePage = new ManagerHomePage(driver);

        Assert.assertTrue("We are in the manager home page.", managerHomePage.managerIdLabelButton.isDisplayed());
    }

    @Test(description = "")
    public void verifyFormValidationMessages(){

        HomePage homePage = new HomePage(driver);

        homePage.userIdTextField.click();
        homePage.passwordTextField.click();
        Assert.assertTrue("user id warning message is displayed when userid field is blank", homePage.emptyUserIDLabel.isDisplayed());
        Assert.assertEquals("user id warning message has the correct text", "User-ID must not be blank", homePage.emptyUserIDLabel.getText());

        homePage.userIdTextField.click();
        Assert.assertTrue("password warning message is displayed when password field is blank", homePage.emptyPasswordLabel.isDisplayed());
        Assert.assertEquals("password warning message has the correct text", "Password must not be blank", homePage.emptyPasswordLabel.getText());


        homePage.enterUserId("test_userid");
        homePage.enterPassword("test_password");
        Assert.assertFalse("user id warning message is not displayed when userid field is filled with text", homePage.emptyUserIDLabel.isDisplayed());
        Assert.assertFalse("password warning message is not displayed when password field is filled with text", homePage.emptyPasswordLabel.isDisplayed());

    }

    @Test(description = "Login with a valid but not registered User Id.")
    public void loginWithNotFoundUserId(){
        UserDTO user = TestDataManager.getUserWithIncorrectUserId();
        verifyLoginWithIncorrectData(user);
    }

    @Test(description = "Login with a registered user Id but incorrect password.")
    public void loginWithIncorrectPassword(){
        UserDTO user = TestDataManager.getUserWithIncorrectPassword();
        verifyLoginWithIncorrectData(user);
    }

    @Test(description = "Login with empty user and password.")
    public void loginWithEmptyUserPassword (){
        UserDTO user = new UserDTO().withUserId("").withUserPassword("");
        verifyLoginWithIncorrectData(user);
    }


    /**
     * Check the alert that should be displayed
     * if the user login to the application with incorrect data.
     * @param user
     */
    public void verifyLoginWithIncorrectData(UserDTO user){
        HomePage homePage = new HomePage(driver);

        try {

            homePage.login(user);
            Alert alert = driver.switchTo().alert();
            String alertMessage = alert.getText();
            Assert.assertEquals("Alert text is displayed with useful information", "User or Password is not valid", alertMessage);
            alert.accept();
            Assert.assertTrue("We are redirected to login window", homePage.userIdTextField.isDisplayed());

        }catch (NoAlertPresentException noAlertPresentException){

            Assert.fail("No alert was displayed to the user.");

        }finally {

            driver.switchTo().defaultContent();
        }
    }


}
