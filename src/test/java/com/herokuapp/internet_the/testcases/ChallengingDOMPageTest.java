package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.ChallengingDOMPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChallengingDOMPageTest extends TestBase {
    ChallengingDOMPage challengingDOMPage;
    HomePage homePage;

    ChallengingDOMPageTest() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        challengingDOMPage = new ChallengingDOMPage();
        challengingDOMPage = homePage.navigateToChallengingDOMPage();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void clickBlueButton() {
        WebElement button = challengingDOMPage.blueButton;
        String beforeClickAttribute = button.getText();
        button.click();
        String actualAttribute = button.getText();
        Assertions.assertNotEquals(beforeClickAttribute, actualAttribute, "Blue button is not clickable");
    }

    @Test
    public void clickRedButton() {
        WebElement button = challengingDOMPage.redButton;
        String beforeClickAttribute = button.getText();
        button.click();
        String actualAttribute = button.getText();
        Assertions.assertNotEquals(beforeClickAttribute, actualAttribute, "Red button is not clickable");
    }

    @Test
    public void clickGreenButton() {
        WebElement button = challengingDOMPage.greenButton;
        String beforeClickAttribute = button.getAttribute("id");
        button.click();
        String actualAttribute = button.getAttribute("id");
        Assertions.assertNotEquals(beforeClickAttribute, actualAttribute, "Green button is not clickable");
    }

    @Test
    public void checkEditButtons() {
        List<WebElement> editElements = driver.findElements(By.linkText("edit"));
        String pastURL = driver.getCurrentUrl();
        for (WebElement element : editElements) {
            element.click();
            String actualURL = driver.getCurrentUrl();
            Assertions.assertNotEquals(pastURL, actualURL, "Edit elements are not clickable");
            if (pastURL.equals(actualURL)) {
                driver.get(pastURL);
            }
        }
    }
    @Test
    public void checkDeleteButtons() {
        List<WebElement> deleteElements = driver.findElements(By.linkText("delete"));
        String pastURL = driver.getCurrentUrl();
        for (WebElement element : deleteElements) {
            element.click();
            String actualURL = driver.getCurrentUrl();
            Assertions.assertNotEquals(pastURL, actualURL, "Delete elements are not clickable");
            if (pastURL.equals(actualURL)) {
                driver.get(pastURL);
            }
        }
    }
}
