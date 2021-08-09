package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.EntryAdPage;
import com.herokuapp.internet_the.pages.ExitIntentPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class ExitIntentPageTest extends TestBase {
    HomePage homepage;
    ExitIntentPage exitIntentPage;
    ExitIntentPageTest() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homepage = new HomePage();
        exitIntentPage = new ExitIntentPage();
        exitIntentPage= homepage.navigateToExitIntentPage();
    }
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void checkIsAdDisplayed() throws AWTException {
        exitIntentPage.hoverOverToDisplay();
        Assertions.assertTrue(exitIntentPage.verifyElementIsDisplayed(exitIntentPage.adLocator),"Ad is not displayed after hovering over specified location");
    }
    @Test
    public void checkIsAdNotDisplayedAfterNavigatingToPage() {
        Assertions.assertTrue(exitIntentPage.verifyElementIsHidden(exitIntentPage.adLocator),"Ad displays when user navigates to page");
    }
    @Test
    public void checkIsAdCloseable() throws AWTException{
        exitIntentPage.hoverOverToDisplay();
        exitIntentPage.closeAd();
        Assertions.assertTrue(exitIntentPage.verifyElementIsHidden(exitIntentPage.adLocator),"Ad is not closeable");
    }
}
