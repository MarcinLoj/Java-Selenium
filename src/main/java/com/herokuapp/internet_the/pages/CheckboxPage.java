package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage extends TestBase {
    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    public WebElement firstCheckbox;
    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    public WebElement secondCheckbox;
    public CheckboxPage() {
        PageFactory.initElements(driver,this);
    }
    public void selectOneCheckbox(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }
    public void selectAllCheckboxes(WebElement element1, WebElement element2) {
        while (!element1.isSelected()) {
                element1.click();
            }
        while (!element2.isSelected()) {
                element2.click();
            }
    }
    public void unSelectOneCheckbox(WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }
    public void unSelectAllCheckboxes(WebElement element1, WebElement element2) {
        while (element1.isSelected()) {
                element1.click();
            }
        while (element2.isSelected()) {
                element2.click();
            }
    }
}
