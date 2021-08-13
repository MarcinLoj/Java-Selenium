package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage extends TestBase {
    @FindBy(xpath = "//div[@class=\"flash success\"]")
    public WebElement successfulAuthorisationNotification;
    @FindBy(xpath = "//*[@class=\"icon-2x icon-signout\"]")
    public WebElement logoutButton;
    public SecureAreaPage() {
        PageFactory.initElements(driver,this);
    }
    public boolean checkIsNotificationDisplayed() {
        waitUntilVisibilityOfElement(logoutButton);
        return successfulAuthorisationNotification.isDisplayed();
    }
    public FormAuthenticationPage clickOnLogoutButton() {
        waitUntilVisibilityOfElement(logoutButton);
        logoutButton.click();
        return new FormAuthenticationPage();
    }
}
