package org.example.pageobjects.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseManagerPage extends BasePage{

    @FindBy(css = "a[href='Managerhomepage.php'")
    public WebElement managerButton;
    @FindBy(css = "a[href='addcustomerpage.php'")
    public WebElement newCustomerButton;
    @FindBy(css = "a[href='EditCustomer.php'")
    public WebElement editCustomerButton;
    @FindBy(css = "a[href='DeleteCustomerInput.php'")
    public WebElement deleteCustomerButton;
    @FindBy(css = "a[href='addAccount.php'")
    public WebElement newAccountButton;
    @FindBy(css = "a[href='editAccount.php'")
    public WebElement editAccountButton;
    @FindBy(css = "a[href='deleteAccountInput.php'")
    public WebElement deleteAccountButton;
    @FindBy(css = "a[href='DepositInput.php'")
    public WebElement depositButton;
    @FindBy(css = "a[href='WithdrawalInput.php'")
    public WebElement withdrawalButton;
    @FindBy(css = "a[href='FundTransInput.php'")
    public WebElement fundTransferButton;
    @FindBy(css = "a[href='PasswordInput.php'")
    public WebElement changePasswordButton;
    @FindBy(css = "a[href='BalEnqInput.php'")
    public WebElement balanceEnquiryButton;
    @FindBy(css = "a[href='MiniStatementInput.php'")
    public WebElement miniStatementButton;
    @FindBy(css = "a[href='CustomisedStatementInput.php'")
    public WebElement customisedStatementButton;
    @FindBy(css = "a[href='Logout.php'")
    public WebElement logoutButton;

    public BaseManagerPage(WebDriver driver) {
        super(driver);
    }
}
