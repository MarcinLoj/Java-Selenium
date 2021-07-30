package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.ChallengingDOMPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChallengingDOMPageTest extends TestBase {
    ChallengingDOMPage challengingDOMPage;
    HomePage homePage;

    ChallengingDOMPageTest() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        challengingDOMPage = new ChallengingDOMPage();
        challengingDOMPage = homePage.navigateToChallengingDOMPage();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void clickBlueButton() {
        challengingDOMPage.click(challengingDOMPage.blueButton);
        Assertions.assertNotEquals(challengingDOMPage.beforeClickButtonGetText, challengingDOMPage.afterClickButtonGetText);
    }

    @Test
    public void clickRedButton() {
        challengingDOMPage.click(challengingDOMPage.redButton);
        Assertions.assertNotEquals(challengingDOMPage.beforeClickButtonGetText, challengingDOMPage.afterClickButtonGetText);
    }

    @Test
    public void clickGreenButton() {
        challengingDOMPage.click(challengingDOMPage.greenButton);
        Assertions.assertNotEquals(challengingDOMPage.beforeClickButtonGetText, challengingDOMPage.afterClickButtonGetText);
    }
    @Test
    public void checkEditButtons() {
        challengingDOMPage.check(challengingDOMPage.editButton,challengingDOMPage.editElementsLocatedOnPage);
        Assertions.assertTrue(challengingDOMPage.returnNotPassedClicks() == 0, "Edit button counting " +
                "from the top is not clickable => " + challengingDOMPage.countClicks);

    }
    @Test
    public void checkDeleteButtons() {
        challengingDOMPage.check(challengingDOMPage.editButton, challengingDOMPage.deleteElementsLocatedOnPage);
        Assertions.assertTrue(challengingDOMPage.returnNotPassedClicks() == 0, "Delete button counting " +
                "from the top is not clickable => " + challengingDOMPage.countClicks);

    }
}
