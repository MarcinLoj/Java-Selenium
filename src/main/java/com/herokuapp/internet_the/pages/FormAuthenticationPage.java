package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthenticationPage extends TestBase {
    public String correctUsername = prop.getProperty("username");
    public String correctPassword = prop.getProperty("password");
    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement usernameField;
    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passwordField;
    @FindBy(xpath = "//*[@class=\"radius\"]")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@id=\"flash\"]")
    public WebElement notificationAboutLogin;
    public FormAuthenticationPage() {
        PageFactory.initElements(driver,this);
    }
    public void loginWith(String username, String password) {
        waitUntilVisibilityOfElement(usernameField);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
    public String checkNotificationContent() {
        return notificationAboutLogin.getText();
    }
}
