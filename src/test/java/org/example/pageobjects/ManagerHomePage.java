package org.example.pageobjects;

import org.example.pageobjects.common.BaseManagerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerHomePage extends BaseManagerPage {



    @FindBy(css = "td[style=\"color: green\"]")
    public WebElement managerIdLabelButton;


    public ManagerHomePage(WebDriver driver) {
        super(driver);
    }
}
