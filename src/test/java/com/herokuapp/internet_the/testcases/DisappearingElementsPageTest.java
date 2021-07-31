package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.DigestAuthenticationPage;
import com.herokuapp.internet_the.pages.DisappearingElementsPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DisappearingElementsPageTest extends TestBase {
    DisappearingElementsPage disappearingElementsPage;
    HomePage homePage;

    DisappearingElementsPageTest() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        disappearingElementsPage = new DisappearingElementsPage();
        disappearingElementsPage = homePage.navigateToDisappearingElementsPage();
    }

    @AfterEach
    public void tearDown() { driver.close();
    }

    @Test
    public void checkIfElementsDisappearOrAppear() {
        disappearingElementsPage.locateAllElementsOnThePage();
        disappearingElementsPage.userRefreshPageUntilElementAppearOrDisappear();
        Assertions.assertNotEquals(disappearingElementsPage.listSize.size(), disappearingElementsPage.allElementsLocatedOnPage.size(),
                "One of the elements which should be located on page disappears or appears after refresh. His name is "
                        + disappearingElementsPage.missingElement);
    }

}
