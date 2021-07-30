package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ChallengingDOMPage extends TestBase {
    public String beforeClickButtonGetText;
    public String afterClickButtonGetText;
    public String beforeClickButtonGetAttribute;
    public String afterClickButtonGetAttribute;
    public String pastURL;
    public String actualURL;
    public List<WebElement> editElementsLocatedOnPage = driver.findElements(By.linkText("edit"));
    public List<WebElement> deleteElementsLocatedOnPage = driver.findElements(By.linkText("delete"));
    public List<Integer> countClicks = new ArrayList<>();
    @FindBy(className = "button")
    public WebElement blueButton;
    @FindBy(xpath = "//*[@class='button alert']")
    public WebElement redButton;
    @FindBy(xpath = "//*[@class='button success']")
    public WebElement greenButton;
    @FindBy(linkText = "edit")
    public WebElement editButton;
    @FindBy(linkText = "delete")
    public WebElement deleteButton;

    public ChallengingDOMPage() {
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        this.beforeClickButtonGetText = element.getText();
        this.beforeClickButtonGetAttribute = element.getAttribute("id");
        element.click();
        this.afterClickButtonGetText = element.getText();
        this.afterClickButtonGetAttribute = element.getAttribute("id");
    }

    public void check(WebElement element, List<WebElement> list) {
        int i = 0;
        this.pastURL = driver.getCurrentUrl();
        for (WebElement ignored : list) {
            element.click();
            this.actualURL = driver.getCurrentUrl();
            if (driver.getCurrentUrl().equals(actualURL)) {
                driver.get(pastURL);
            }
            if (driver.getCurrentUrl().equals(actualURL)) {
                ++i;
                countClicks.add(i);
            }
        }
    }
    public int returnNotPassedClicks() {
        return countClicks.size();
    }
}


