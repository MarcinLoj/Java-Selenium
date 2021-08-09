package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;


public class ExitIntentPage extends TestBase {
    @FindBy(xpath = "//*[@id=\"ouibounce-modal\"]")
    public WebElement adLocator;
    @FindBy(xpath = "//*[@id=\"ouibounce-modal\"]/div[2]/div[3]/p")
    public WebElement closeAdLocator;

    public ExitIntentPage() {
        PageFactory.initElements(driver,this);
    }
    public void hoverOverToDisplay() throws AWTException {
        Robot robot = new Robot();
        while (adLocator.getAttribute("style").equals("display: none;")) {
            robot.mouseMove(1800, 600);
            robot.mouseMove(1800, 0);
        }
    }
    public void closeAd() {
        waitUntilVisibilityOfElement(closeAdLocator);
        closeAdLocator.click();
    }
    public boolean verifyElementIsDisplayed(WebElement element) {
        waitUntilVisibilityOfElement(element);
        return (element.getAttribute("style").equals("display: block;"));
    }
    public boolean verifyElementIsHidden(WebElement element) {
        return (element.getAttribute("style").equals("display: none;"));
    }

}
