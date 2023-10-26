package org.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        String DRIVER_PATH = "src/test/resources/chromedriver";
        String DRIVER_PROPERTY = "webdriver.chrome.driver";
        String URL = "https://demo.guru99.com/V4/";
        System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //acceptCookies();
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

    /**
     * Waits to the browser to be displayed and accept the cookies.
     * @throws InterruptedException
     */
    public void acceptCookies() throws InterruptedException {

        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.cssSelector(".faktor-iframe-wrapper")));
        if(!driver.findElements(By.id("save")).isEmpty())
            driver.findElement(By.id("save")).click();
        driver.switchTo().defaultContent();
    }





}
