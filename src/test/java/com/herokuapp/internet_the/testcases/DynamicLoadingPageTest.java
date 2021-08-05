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

public class DynamicLoadingPageTest extends TestBase {
    HomePage homepage;
    DynamicLoadingPage dynamicLoadingPage;
    DynamicLoadingPage1 dynamicLoadingPage1;
    DynamicLoadingPage2 dynamicLoadingPage2;

    DynamicLoadingPageTest() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homepage = new HomePage();
        dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage = homepage.navigateToDynamicLoadingPage();
        dynamicLoadingPage1 = new DynamicLoadingPage1();
        dynamicLoadingPage2 = new DynamicLoadingPage2();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void navigateToDynamicLoadingPage1() {
        dynamicLoadingPage.navigateToDynamicLoadingPage1();
        Assertions.assertTrue(dynamicLoadingPage.verifyUserNavigatedToLoadingPage1(), "User has not navigated correctly to the dynamic loading page 1");
    }
    @Test
    public void navigateToDynamicLoadingPage2() {
        dynamicLoadingPage.navigateToDynamicLoadingPage2();
        Assertions.assertTrue(dynamicLoadingPage.verifyUserNavigatedToLoadingPage2(), "User has not navigated correctly to the dynamic loading page 2");
    }
}
