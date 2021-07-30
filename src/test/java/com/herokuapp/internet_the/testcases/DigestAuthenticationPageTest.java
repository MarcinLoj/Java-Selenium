package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.ContextMenuPage;
import com.herokuapp.internet_the.pages.DigestAuthenticationPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DigestAuthenticationPageTest extends TestBase {
    DigestAuthenticationPage digestAuthenticationPage;
    HomePage homePage;

    DigestAuthenticationPageTest() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        digestAuthenticationPage = new DigestAuthenticationPage();
        digestAuthenticationPage = homePage.navigateToDigestAuthenticationPage();
    }

    @AfterEach
    public void tearDown() { driver.close();
    }

    @Test
    public void userBypassDigestAuthentication() {
        digestAuthenticationPage.userBypassDigestAuthenticator();
        String digestAuthorizationMessage = digestAuthenticationPage.digestAuthMessageLocator.getText();
        Assertions.assertEquals("Digest Auth", digestAuthorizationMessage, "User has not been authorized");
    }

}
