package org.example.pageobjects;

import org.example.testdata.dto.UserDTO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    private final String pageURL = "https://demo.guru99.com/V4/";

    @FindBy(css = "a[href=\"http://demo.guru99.com/\"]")
    public WebElement hereRef;

    @FindBy(css = ".barone")
    public WebElement formLoginTitle;

    @FindBy(name = "uid")
    public WebElement userIdTextField;

    @FindBy(name = "password")
    public WebElement passwordTextField;

    @FindBy(name = "btnLogin")
    public WebElement btnLogin;

    @FindBy(name = "btnReset")
    public WebElement btnReset;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        if (!pageURL.equals(this.driver.getCurrentUrl())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public void enterUserId(String userId){
        userIdTextField.sendKeys(userId);
    }

    public void enterPassword(String password){
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton(){
        btnLogin.click();
    }

    public void clickResetButton(){
        btnReset.click();
    }


    public ManagerHomePage login (UserDTO userData){
        enterUserId(userData.getUserId());
        enterPassword(userData.getUserPassword());
        clickLoginButton();
        return new ManagerHomePage(driver);
    }


}
