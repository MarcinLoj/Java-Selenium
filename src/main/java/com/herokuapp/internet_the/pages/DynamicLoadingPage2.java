package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage2 extends TestBase {
    @FindBy(xpath = "//*[@id=\"finish\"]/h4")
    public WebElement helloWorldMessage;
    @FindBy(xpath = "//*[@id=\"start\"]/button")
    public WebElement startButton;

    public DynamicLoadingPage2() {
        PageFactory.initElements(driver,this);
    }

    public void clickStartButton() {
        waitUntilVisibilityOfElement(startButton);
        startButton.click();
        waitUntilVisibilityOfElement(helloWorldMessage);
    }
    public boolean verifyHelloWorldMessageIsDisplayed() {
        return helloWorldMessage.isDisplayed();
    }
}
