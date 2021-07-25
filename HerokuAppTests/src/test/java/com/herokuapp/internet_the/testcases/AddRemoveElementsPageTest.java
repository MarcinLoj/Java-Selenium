package com.herokuapp.internet_the.testcases;

import com.herokuapp.internet_the.base.TestBase;
import com.herokuapp.internet_the.pages.AddRemoveElementsPage;
import com.herokuapp.internet_the.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AddRemoveElementsPageTest extends TestBase {
    HomePage homePage;
    AddRemoveElementsPage addRemoveElementsPage;
    AddRemoveElementsPageTest() { super(); }
    @BeforeEach
    public void setUp() {
        initialization();
        homePage = new HomePage();
        addRemoveElementsPage = new AddRemoveElementsPage();
        addRemoveElementsPage = homePage.navigateToAddRemoveElementsPage();
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
    @Test
    public void addElementsTest() {
        addRemoveElementsPage.addItems(30);
        Assertions.assertTrue(addRemoveElementsPage.verifyItemsHasBeenAdded(), "Items has not been added");
    }
    @Test
    public void deleteAllAddedElementsTest() {
        int deletedItemsCount = addRemoveElementsPage.verifyItemsHasBeenDeleted();
        addRemoveElementsPage.addItems(10);
        addRemoveElementsPage.deleteAddedItems();
        Assertions.assertTrue(deletedItemsCount == 0, "Items has not been deleted");
    }
}
