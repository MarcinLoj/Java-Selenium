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
        checkboxPage.unSelectCheckbox(checkboxPage.firstCheckbox);
        checkboxPage.selectCheckbox(checkboxPage.firstCheckbox);
        Assertions.assertTrue(checkboxPage.firstCheckbox.isSelected(), "First checkbox is not selectable");
    }
    @Test
    public void isSecondCheckboxSelectable() {
        checkboxPage.unSelectCheckbox(checkboxPage.secondCheckbox);
        checkboxPage.selectCheckbox(checkboxPage.secondCheckbox);
        Assertions.assertTrue(checkboxPage.secondCheckbox.isSelected(), "Second checkbox is not selectable");
    }
    @Test
    public void areAllCheckboxesSelectable() {
        checkboxPage.unSelectCheckbox(checkboxPage.firstCheckbox, checkboxPage.secondCheckbox);
        checkboxPage.selectCheckbox(checkboxPage.firstCheckbox, checkboxPage.secondCheckbox);
        checkboxPage.countIfFailToSelect(checkboxPage.firstCheckbox, checkboxPage.secondCheckbox);
        Assertions.assertTrue((checkboxPage.firstCheckbox.isSelected() && checkboxPage.secondCheckbox.isSelected()),
                "Counting from the top, which checkboxes are not selectable " + checkboxPage.countFailedCheckboxes);
    }
    @Test
    public void isFirstCheckboxUnselectable() {
        checkboxPage.selectCheckbox(checkboxPage.firstCheckbox);
        checkboxPage.unSelectCheckbox(checkboxPage.firstCheckbox);
        Assertions.assertFalse(checkboxPage.firstCheckbox.isSelected(), "First checkbox cannot be unselected");
    }
    @Test
    public void isSecondCheckboxUnselectable() {
        checkboxPage.selectCheckbox(checkboxPage.secondCheckbox);
        checkboxPage.unSelectCheckbox(checkboxPage.secondCheckbox);
        Assertions.assertFalse(checkboxPage.secondCheckbox.isSelected(), "Second checkbox cannot be unselected");
    }
    @Test
    public void areAllCheckboxesUnselectable() {
        checkboxPage.selectCheckbox(checkboxPage.firstCheckbox, checkboxPage.secondCheckbox);
        checkboxPage.unSelectCheckbox(checkboxPage.firstCheckbox, checkboxPage.secondCheckbox);
        checkboxPage.countIfFailToUnSelect(checkboxPage.firstCheckbox, checkboxPage.secondCheckbox);
        Assertions.assertFalse((checkboxPage.firstCheckbox.isSelected() && checkboxPage.secondCheckbox.isSelected()),
                "Counting from the top, which checkboxes are not unselectable " + checkboxPage.countFailedCheckboxes);
    }
}
