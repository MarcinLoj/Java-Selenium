package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChallengingDOMPage extends TestBase {
    @FindBy(className = "button")
    public WebElement blueButton;
    @FindBy(xpath = "//*[@class='button alert']")
    public WebElement redButton;
    @FindBy(xpath = "//*[@class='button success']")
    public WebElement greenButton;

    public ChallengingDOMPage() {
        PageFactory.initElements(driver,this);
    }
}
