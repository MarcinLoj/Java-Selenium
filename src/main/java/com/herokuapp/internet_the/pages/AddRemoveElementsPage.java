package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElementsPage extends TestBase {
    int count;

    @FindBy(xpath = "//*[@id=\"elements\"]/button[1]")
    public static WebElement deleteButton;

    @FindBy(css = "#content > div > button")
    public static WebElement addButton;

    public AddRemoveElementsPage() {
        PageFactory.initElements(driver,this);
    }

    public void deleteAddedItems() {
        int i = 0;
        while (i < count) {
            deleteButton.click();
            ++i;
        }
    }
    public void addItems(int count) {
        waitUntilVisibilityOfElement(addButton);
        int i = 0;
        this.count = count;
        while (i < count) {
            addButton.click();
            ++i;
        }
    }
    public boolean verifyItemsHasBeenAdded() {
        return driver.findElement(By.xpath("//*[@id=\"elements\"]/button["+count+"]")).isDisplayed();
    }
    public int verifyItemsHasBeenDeleted() {
        return driver.findElements(By.xpath("//*[@id=\"elements\"]/button[1]")).size();
    }
}

