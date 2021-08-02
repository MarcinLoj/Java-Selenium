package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.DynamicControlsPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicControlsPageTest extends TestBase {
    HomePage homepage;
    DynamicControlsPage dynamicControlsPage;


    DynamicControlsPageTest() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homepage = new HomePage();
        dynamicControlsPage = new DynamicControlsPage();
        dynamicControlsPage = homepage.navigateToDynamicControlsPage();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void isCheckboxClickable() {
        dynamicControlsPage.clickToAddCheckbox();
        Assertions.assertTrue(dynamicControlsPage.verifyIsCheckboxSelected(), "Checkbox is not selectable");
    }
    @Test
    public void removeCheckbox() {
        dynamicControlsPage.clickToAddCheckbox();
        dynamicControlsPage.clickRemoveButton();
        Assertions.assertTrue(dynamicControlsPage.verifyIsCheckboxRemoved(), "Checkbox has not been removed");
    }
    @Test
    public void addCheckbox() {
        dynamicControlsPage.clickRemoveButton();
        dynamicControlsPage.clickAddButton();
        Assertions.assertTrue(dynamicControlsPage.verifyIsCheckboxAdded(), "Checkbox has not been added");
    }
    @Test
    public void checkIsEnableButtonClickable() {
        dynamicControlsPage.clickEnableButton();
        Assertions.assertTrue(dynamicControlsPage.verifyIsEnableButtonClickable(), "Enable button is not clickable");
    }
    @Test
    public void checkIsDisableButtonClickable() {
        dynamicControlsPage.clickEnableButton();
        dynamicControlsPage.clickDisableButton();
        Assertions.assertTrue(dynamicControlsPage.verifyIsDisableButtonClickable(), "Disable button is not clickable");
    }

}
