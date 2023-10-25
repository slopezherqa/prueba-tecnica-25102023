package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{

    @FindBy(id = "emailid")
    public WebElement emailIdTextField;

    @FindBy(id = "btnLogin")
    public WebElement submitButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

}
