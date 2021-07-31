package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DisappearingElementsPage extends TestBase {
    public List<WebElement> allElementsLocatedOnPage;
    public List<WebElement> listSize;
    public String missingElement;

    public void locateAllElementsOnThePage() {
        allElementsLocatedOnPage = driver.findElements(By.tagName("li"));
        listSize = driver.findElements(By.tagName("li"));
    }

    public void userRefreshPageUntilElementAppearOrDisappear() {
        while (listSize.size() == allElementsLocatedOnPage.size()) {
            driver.navigate().refresh();
            allElementsLocatedOnPage = driver.findElements(By.tagName("li"));
            if (allElementsLocatedOnPage.size() < listSize.size()) {
                this.missingElement = allElementsLocatedOnPage.get(allElementsLocatedOnPage.size() - 1).getText() +
                        " and it has appeared to the DOM";
            } else
                this.missingElement = "Unable to locate element because it disappeared from the DOM";
        }
    }
}
