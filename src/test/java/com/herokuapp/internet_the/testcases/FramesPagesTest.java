package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.FramesPage;
import com.herokuapp.internet_the.pages.HomePage;
import com.herokuapp.internet_the.pages.IFramePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FramesPagesTest extends TestBase {
    HomePage homePage;
    FramesPage framesPage;
    IFramePage iFramePage;
    FramesPagesTest() {
        super();
    }
    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        framesPage = new FramesPage();
        iFramePage = new IFramePage();
        framesPage = homePage.navigateToFramesPage();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void navigateToIFramesPage() {
        framesPage.navigateToiFramePage();
        Assertions.assertEquals("An iFrame containing the TinyMCE WYSIWYG Editor", iFramePage.getTextFrom(iFramePage.pageHeader),
                "User has not been navigated to the iFramePage succesfully");
    }
}
