package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasicAuthPage extends TestBase {
    public String basicAuthAuthenticate = "http://admin:admin@the-internet.herokuapp.com/basic_auth";
    @FindBy(css = "#content > div > h3")
    public WebElement basicAuthMessageDisplayed;

    public BasicAuthPage() {
        PageFactory.initElements(driver,this);
    }

    public void userBypassAlert() {
        driver.get(basicAuthAuthenticate);
    }

}