package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.DynamicLoadingPage;
import com.herokuapp.internet_the.pages.DynamicLoadingPage1;
import com.herokuapp.internet_the.pages.DynamicLoadingPage2;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicLoadingPageTest1 extends TestBase {
    HomePage homepage;
    DynamicLoadingPage dynamicLoadingPage;
    DynamicLoadingPage1 dynamicLoadingPage1;

    DynamicLoadingPageTest1() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homepage = new HomePage();
        dynamicLoadingPage = homepage.navigateToDynamicLoadingPage();
        dynamicLoadingPage1 = dynamicLoadingPage.navigateToDynamicLoadingPage1();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void isHelloWorldDisplayed() {
        dynamicLoadingPage1.clickStartButton();
        Assertions.assertTrue(dynamicLoadingPage1.verifyHelloWorldMessageIsDisplayed());
    }
}
