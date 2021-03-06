package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryAdPage extends TestBase {
    @FindBy(xpath = "//*[@id=\"modal\"]")
    public WebElement adLocator;
    @FindBy(xpath = "//*[@id=\"modal\"]/div[2]/div[3]/p")
    public WebElement closeAdLocator;

    public EntryAdPage() {
        PageFactory.initElements(driver, this);
    }

    public void closeAd() {
        waitUntilVisibilityOfElement(closeAdLocator);
        closeAdLocator.click();
    }

    public boolean verifyElementDisplays(WebElement element) {
        waitUntilVisibilityOfElement(element);
        return (element.getAttribute("style").equals("display: block;"));
    }

    public boolean verifyElementIsHidden(WebElement element) {
        return (element.getAttribute("style").equals("display: none;"));
    }
}
