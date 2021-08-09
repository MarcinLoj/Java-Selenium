package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.EntryAdPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntryAdPageTest extends TestBase {
    HomePage homepage;
    EntryAdPage entryAdPage;

    EntryAdPageTest() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homepage = new HomePage();
        entryAdPage = new EntryAdPage();
        entryAdPage = homepage.navigateToEntryAdPage();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void checkIsAdDisplayed() {
        Assertions.assertTrue(entryAdPage.verifyElementDisplays(entryAdPage.adLocator));
    }
    @Test
    public void checkIsAdCloseable() {
        entryAdPage.closeAd();
        Assertions.assertTrue(entryAdPage.verifyElementIsHidden(entryAdPage.adLocator));
    }
}
