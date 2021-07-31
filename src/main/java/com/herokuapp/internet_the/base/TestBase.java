package com.herokuapp.internet_the.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop = new Properties();

    public TestBase() {
        try {
            FileInputStream ip = new FileInputStream("/home/mrcn/SeleniumJUnit/Tests-with-Selenium-JUnit-TestNG/HerokuAppTests/src/main/java/com/herokuapp/internet_the/config/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initialization() {
        String browserName = prop.getProperty("browser");
        String osName = prop.getProperty("OS");
        String url = prop.getProperty("url");
        if (osName.equals("windows")) {
            if (browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "#Set path to chromedriver");
                driver = new ChromeDriver();
            }
            else if (browserName.equals("FF")) {
                System.setProperty("webdriver.gecko.driver", "#Set path to geckodriver");
                driver = new FirefoxDriver();
            }
            else
                System.err.println("Driver has not been selected.\n In order to start test cases," +
                                    "fix it immediately");
        }
        else if (osName.equals("linux")) {
            if (browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver");
                driver = new ChromeDriver();
            }
            else if (browserName.equals("FF")) {
                System.setProperty("webdriver.gecko.driver", "#Set path to geckodriver");
                driver = new FirefoxDriver();
            }
            else
                System.err.println("Driver has not been selected.\n In order to start test cases," +
                        "fix it immediately");
        }
        else
            System.err.println("OS has not been selected.\n In order to start test cases," +
                    "fix it immediately");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
    }
    public void waitUntilVisibilityOfElement(WebElement element) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }
}
