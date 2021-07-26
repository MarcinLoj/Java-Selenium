package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.BasicAuthPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.*;

public class BasicAuthPageTest extends TestBase {
    BasicAuthPage basicAuthPage;
    HomePage homePage;
    BasicAuthPageTest() { super(); }
    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        basicAuthPage = new BasicAuthPage();
        basicAuthPage = homePage.navigateToBasicAuthPage();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void userBypassLogin() {
        basicAuthPage.userBypassAlert();
        String verifyUserHasBeenLoggedIn = basicAuthPage.basicAuthMessageDisplayed.getText();
        Assertions.assertEquals(verifyUserHasBeenLoggedIn, "Basic Auth", "User has not been authorized");
    }
}
