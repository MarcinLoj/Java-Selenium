package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.DynamicContentPage;
import com.herokuapp.internet_the.pages.HomePage;
import com.herokuapp.internet_the.pages.StaticContentPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StaticContentPageTest extends TestBase {
    HomePage homepage;
    DynamicContentPage dynamicContentPage;
    StaticContentPage staticContentPage;
    StaticContentPageTest() {
        super();
    }
    @BeforeEach
    public void setUp() {
        initialization();
        homepage = new HomePage();
        dynamicContentPage = new DynamicContentPage();
        staticContentPage = new StaticContentPage();
        dynamicContentPage = homepage.navigateToDynamicContentPage();
        staticContentPage = dynamicContentPage.navigateToStaticContentPage();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void checkIsElementContentChangingAfterReload() {
        staticContentPage.checkIsContentChanging();
        Assertions.assertTrue(staticContentPage.verifyIsChanged(),
                "Content in some element didn't changed, here is xpath navigating to element which failed to change: "
                        + "\n" + staticContentPage.listAfterReload.get(0) + "\n and number based from the top in DOM -> " + staticContentPage.compareTwoListsHelper
                        + "\n" + "To report a bug open page, open DevTools, switch to console, press ctrl + f, paste xpath locator."
                        + "\n" + "Number printed in the IDE console, is a navigator, this element which failed to change content,"
                        + "\n" + "is a element number counting from the top in the DOM. For ex. 'Second photo failed to change,"
                        + "\n" + "so its a second element counting from the top in the DOM' ");
    }
}
