package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;

public class FloatingMenuPage extends TestBase {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    public List<WebElement> floatingButtonsList = driver.findElements(By.xpath("//ul//li//child::a"));
    public List<WebElement> paragraphsList = driver.findElements(By.xpath("//div[@class=\"scroll large-10 columns large-centered\"]//child::p"));
    public HashMap<Point, String> helper = new HashMap<>();
    @FindBy(xpath = "//ul//li[1]/a")
    public WebElement homeButton;
    @FindBy(xpath = "//ul//li[2]/a")
    public WebElement newsButton;
    @FindBy(xpath = "//ul//li[3]/a")
    public WebElement contactButton;
    @FindBy(xpath = "//ul//li[4]/a")
    public WebElement aboutButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    public WebElement pageTitle;

    public FloatingMenuPage() {
        PageFactory.initElements(driver, this);
    }

    public void scrollThroughAllParagraphs() {
        waitUntilVisibilityOfElement(pageTitle);
        for (WebElement element : paragraphsList) {
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            wait.until(ExpectedConditions.visibilityOfAllElements(floatingButtonsList));
            returnWhichButtonNotDisplays();
        }
    }

    public boolean checkAreAllButtonsDisplayed() {
        return (homeButton.isDisplayed() && newsButton.isDisplayed() && contactButton.isDisplayed() && aboutButton.isDisplayed());
    }
    public void returnWhichButtonNotDisplays() {
         if (!(homeButton.isDisplayed())) {
            helper.put(homeButton.getLocation(), homeButton.getAttribute("href"));
        }
        if (!(newsButton.isDisplayed())) {
            helper.put(newsButton.getLocation(), newsButton.getAttribute("href"));
        }
        if (!(contactButton.isDisplayed())) {
            helper.put(contactButton.getLocation(), contactButton.getAttribute("href"));
        }
        if (!(aboutButton.isDisplayed())) {
            helper.put(aboutButton.getLocation(), aboutButton.getAttribute("href"));
        }
    }
}