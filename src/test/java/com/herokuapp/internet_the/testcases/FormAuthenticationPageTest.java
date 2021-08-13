package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.FormAuthenticationPage;
import com.herokuapp.internet_the.pages.HomePage;
import com.herokuapp.internet_the.pages.SecureAreaPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FormAuthenticationPageTest extends TestBase {
    HomePage homepage;
    FormAuthenticationPage formAuthenticationPage;
    SecureAreaPage secureAreaPage;
    FormAuthenticationPageTest() {
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
    public void loggingInWithCorrectCredentials() {
        formAuthenticationPage.loginWith(formAuthenticationPage.correctUsername, formAuthenticationPage.correctPassword);
        Assertions.assertTrue(secureAreaPage.checkIsNotificationDisplayed(), "User has not been correctly logged in");
    }
    @Test
    public void loggingInWithWrongUsername() {
        formAuthenticationPage.loginWith("wrong username", formAuthenticationPage.correctPassword);
        Assertions.assertEquals("Your username is invalid!\n" +
                "×",formAuthenticationPage.checkNotificationContent(), "User has not been correctly logged in");
    }
    @Test
    public void loggingInWithWrongPassword() {
        formAuthenticationPage.loginWith(formAuthenticationPage.correctUsername, "wrong password");
        Assertions.assertEquals("Your password is invalid!\n" +
                "×", formAuthenticationPage.checkNotificationContent(), "User has not been correctly logged in");
    }
}
