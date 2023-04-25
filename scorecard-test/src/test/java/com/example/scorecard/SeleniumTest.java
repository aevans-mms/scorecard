package com.example.scorecard;

import java.io.IOException;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

public class SeleniumTest
{
    Logger log;
    WebDriver driver;
    FluentWait<WebDriver> wait;

    @BeforeSuite()
    static public void init() throws IOException
    {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod()
    public void setup()
    {
        log = Logger.getLogger(this.getClass());

        driver = getDriver();
        driver.manage().window().maximize();

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1));
    }

    @AfterMethod()
    public void teardown()
    {
        pause(5);
        driver.quit();
    }

    public WebDriver getDriver()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); // fix for Chrome 111 bug

        driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    public void pause(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
