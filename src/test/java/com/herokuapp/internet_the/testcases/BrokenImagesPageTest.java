package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.BrokenImagesPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BrokenImagesPageTest extends TestBase {
    BrokenImagesPage brokenImagesPage;
    HomePage homePage;
    BrokenImagesPageTest() { super(); }
    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        brokenImagesPage = new BrokenImagesPage();
        brokenImagesPage = homePage.navigateToBrokenImagesPage();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void checkIsImageBroken() throws IOException {
        brokenImagesPage.isImageBroken();
        brokenImagesPage.displayBrokenImages();
        Assertions.assertTrue(brokenImagesPage.verifyIsBroken(), "Broken Images are displayed");
    }
}
