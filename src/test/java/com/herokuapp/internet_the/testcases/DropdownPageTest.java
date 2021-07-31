package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.DropdownPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DropdownPageTest extends TestBase {
    HomePage homePage;
    DropdownPage dropdownPage;
    DropdownPageTest() {
        super();
    }
    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        dropdownPage = new DropdownPage();
        dropdownPage = homePage.navigateToDropdownPage();
    }
    @AfterEach
    public void tearDown() {
    }
    @Test
    public void chooseFirstOptionFromDropdownList() {
        dropdownPage.chooseOptionFromDropdownList(dropdownPage.dropDownListButton, "1");
        Assertions.assertTrue(dropdownPage.countSelectedOptions() >= 0, "First option from dropdown list has not been selected");
    }
    @Test
    public void chooseSecondOptionFromDropdownList() {
        dropdownPage.chooseOptionFromDropdownList(dropdownPage.dropDownListButton, "2");
        Assertions.assertTrue(dropdownPage.countSelectedOptions() >= 0, "Second option from dropdown list has not been selected");
    }
}
