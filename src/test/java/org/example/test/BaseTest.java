package org.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        String DRIVER_PATH = "src/test/resources/chromedriver.exe";
        String DRIVER_PROPERTY = "webdriver.chrome.driver";
        String URL = "https://demo.guru99.com/V4/";
        System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);

        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().maximize();

        acceptCookies();
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }

    /**
     * Waits to the browser to be displayed and accept the cookies.
     * @throws InterruptedException
     */
    public void acceptCookies() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.cssSelector(".faktor-iframe-wrapper")));
        driver.findElement(By.id("save")).click();
        driver.switchTo().defaultContent();
    }





}
