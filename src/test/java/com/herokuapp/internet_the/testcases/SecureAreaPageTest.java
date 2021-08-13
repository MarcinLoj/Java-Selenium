package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.FormAuthenticationPage;
import com.herokuapp.internet_the.pages.HomePage;
import com.herokuapp.internet_the.pages.SecureAreaPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SecureAreaPageTest extends TestBase {
    HomePage homepage;
    FormAuthenticationPage formAuthenticationPage;
    SecureAreaPage secureAreaPage;
    SecureAreaPageTest() {
        super();
    }
    @BeforeEach
    public void setUp() {
        initialization();
        homepage = new HomePage();
        formAuthenticationPage = new FormAuthenticationPage();
        secureAreaPage = new SecureAreaPage();
        formAuthenticationPage = homepage.navigateToFormAuthenticationPage();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void logoutFromAccount() {
        formAuthenticationPage.loginWith(formAuthenticationPage.correctUsername, formAuthenticationPage.correctPassword);
        secureAreaPage.clickOnLogoutButton();
        Assertions.assertEquals("You logged out of the secure area!\n" +
                "×", formAuthenticationPage.checkNotificationContent(), "User has not been logged out from the page");
    }

}
