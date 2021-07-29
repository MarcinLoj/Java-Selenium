package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.CheckboxPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class CheckboxPageTest extends TestBase {
    CheckboxPage checkboxPage;
    HomePage homePage;

    CheckboxPageTest() {
        super();
    }

    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        checkboxPage = new CheckboxPage();
        checkboxPage = homePage.navigateToCheckboxPage();
    }

    @AfterEach
    public void tearDown() { driver.close();
    }

    @Test
    public void isFirstCheckboxSelectable() {
        WebElement firstCheckbox = checkboxPage.firstCheckbox;
        checkboxPage.unSelectOneCheckbox(firstCheckbox);
        checkboxPage.selectOneCheckbox(firstCheckbox);
        Assertions.assertTrue(firstCheckbox.isSelected());
    }
    @Test
    public void isSecondCheckboxSelectable() {
        WebElement secondCheckbox = checkboxPage.secondCheckbox;
        checkboxPage.unSelectOneCheckbox(secondCheckbox);
        checkboxPage.selectOneCheckbox(secondCheckbox);
        Assertions.assertTrue(secondCheckbox.isSelected());
    }
    @Test
    public void areAllCheckboxesSelectable() {
        WebElement firstCheckbox = checkboxPage.firstCheckbox;
        WebElement secondCheckbox = checkboxPage.secondCheckbox;
        checkboxPage.unSelectAllCheckboxes(firstCheckbox,secondCheckbox);
        checkboxPage.selectAllCheckboxes(firstCheckbox,secondCheckbox);
        Assertions.assertTrue((firstCheckbox.isSelected() && secondCheckbox.isSelected()));
    }
    @Test
    public void isFirstCheckboxUnselectable() {
        WebElement firstCheckbox = checkboxPage.firstCheckbox;
        checkboxPage.selectOneCheckbox(firstCheckbox);
        checkboxPage.unSelectOneCheckbox(firstCheckbox);
        Assertions.assertFalse(firstCheckbox.isSelected());
    }
    @Test
    public void isSecondCheckboxUnselectable() {
        WebElement secondCheckbox = checkboxPage.secondCheckbox;
        checkboxPage.selectOneCheckbox(secondCheckbox);
        checkboxPage.unSelectOneCheckbox(secondCheckbox);
        Assertions.assertFalse(secondCheckbox.isSelected());
    }
    @Test
    public void areAllCheckboxesUnselectable() {
        WebElement firstCheckbox = checkboxPage.firstCheckbox;
        WebElement secondCheckbox = checkboxPage.secondCheckbox;
        checkboxPage.selectAllCheckboxes(firstCheckbox,secondCheckbox);
        checkboxPage.unSelectAllCheckboxes(firstCheckbox,secondCheckbox);
        Assertions.assertFalse((firstCheckbox.isSelected() && secondCheckbox.isSelected()));
    }
}
