package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import okio.Timeout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DynamicLoadingPage1 extends TestBase {
    @FindBy(xpath = "//button[starts-with(text(),Start)]")
    public WebElement startButton;
    @FindBy(xpath = "//h4[starts-with(text(),'Hello World!')]")
    public WebElement helloWorldMessage;
    @FindBy(xpath = "//div[@id=\"loading\"]")
    public WebElement loadingBar;
    public DynamicLoadingPage1() {
        PageFactory.initElements(driver,this);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    public void clickStartButton() {
            try {
                Thread.sleep(7000);
                js.executeScript("arguments[0].click();", startButton);
                Thread.sleep(8000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    public boolean verifyHelloWorldMessageIsDisplayed() {
        return helloWorldMessage.isDisplayed();
    }
}
