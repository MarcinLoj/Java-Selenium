package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.FloatingMenuPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FloatingMenuPageTest extends TestBase {
    HomePage homePage;
    FloatingMenuPage floatingMenuPage;
    FloatingMenuPageTest() {
        super();
    }
    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        floatingMenuPage = new FloatingMenuPage();
        floatingMenuPage = homePage.navigateToFloatingMenuPage();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void checkFloatingMenuDisplayedWhenUserScrollsPage() {
        floatingMenuPage.scrollThroughAllParagraphs();
        Assertions.assertTrue(floatingMenuPage.checkAreAllButtonsDisplayed(), "Buttons are not displayed while scrolling down, "
        + "\n here are which (location and name): " + floatingMenuPage.helper);
    }
}
