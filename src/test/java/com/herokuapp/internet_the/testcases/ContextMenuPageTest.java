package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.ContextMenuPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoAlertPresentException;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ContextMenuPageTest extends TestBase {
    ContextMenuPage contextMenuPage;
    HomePage homePage;

    ContextMenuPageTest() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        contextMenuPage = new ContextMenuPage();
        contextMenuPage = homePage.navigateToContextMenuPage();
    }

    @AfterEach
    public void tearDown() { driver.close();
    }

    @Test
    public void isContextMenuClickable() {
        contextMenuPage.rightClickOnContextMenu();
        Assertions.assertEquals("You selected a context menu", contextMenuPage.getAlertMessage());
    }
}
