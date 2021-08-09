package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryAdPage extends TestBase {
    @FindBy(xpath = "//*[@id=\"modal\" and @style=\"display: block;\"]")
    public WebElement displayedAd;
    @FindBy(xpath = "//*[@id=\"modal\"]/div[2]/div[3]/p")
    public WebElement closeAdLocator;
    @FindBy(xpath = "//*[@id=\"modal\" and @style=\"display: none;\"]")
    public WebElement notVisibleAd;
    public EntryAdPage() {
        PageFactory.initElements(driver,this);
    }
    public void closeAd() {
        waitUntilVisibilityOfElement(closeAdLocator);
        closeAdLocator.click();
    }
    public boolean verifyAdDisplays() {
        waitUntilVisibilityOfElement(displayedAd);
        return displayedAd.isDisplayed();
    }
    public boolean verifyAdIsPresent() {
        try {
            driver.findElement(By.xpath("//*[@id=\"modal\" and @style=\"display: none;\"]"));
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
}
