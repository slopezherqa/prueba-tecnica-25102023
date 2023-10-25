package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerHomePage extends BasePage{

    @FindBy(css = "td[style=\"color: green\"]")
    public WebElement managerIdLabel;
    public ManagerHomePage(WebDriver driver) {
        super(driver);
    }
}
