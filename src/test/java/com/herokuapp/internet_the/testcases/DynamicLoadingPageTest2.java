package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.DynamicLoadingPage;
import com.herokuapp.internet_the.pages.DynamicLoadingPage2;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicLoadingPageTest2 extends TestBase {
    HomePage homepage;
    DynamicLoadingPage dynamicLoadingPage;
    DynamicLoadingPage2 dynamicLoadingPage2;

    DynamicLoadingPageTest2() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homepage = new HomePage();
        dynamicLoadingPage = homepage.navigateToDynamicLoadingPage();
        dynamicLoadingPage2 = dynamicLoadingPage.navigateToDynamicLoadingPage2();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void isHelloWorldDisplayed() {
        dynamicLoadingPage2.clickStartButton();
        Assertions.assertTrue(dynamicLoadingPage2.verifyHelloWorldMessageIsDisplayed(), "Hello world is not displayed in dynamic loading page 1");
    }
}
