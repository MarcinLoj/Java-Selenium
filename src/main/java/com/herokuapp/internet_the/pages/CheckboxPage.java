package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckboxPage extends TestBase {
    int i = 0;
    public List<Integer> countFailedCheckboxes = new ArrayList<>();
    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    public WebElement firstCheckbox;
    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    public WebElement secondCheckbox;
    public CheckboxPage() {
        PageFactory.initElements(driver,this);
    }
    public void selectCheckbox(WebElement element1) {
        if (!element1.isSelected()) {
            element1.click();
            if (element1.isSelected()) {
                countFailedCheckboxes.add(++i);
            }
        }
    }
    public void selectCheckbox(WebElement element1, WebElement element2) {
        if (!element1.isSelected()) {
            element1.click();
            if (!element1.isSelected()) {
                countFailedCheckboxes.add(++i);
            }
        }
        if (!element2.isSelected()) {
            element2.click();
            if (!element2.isSelected()) {
                countFailedCheckboxes.add(++i);
            }
        }
    }
    public void unSelectCheckbox(WebElement element) {
        if (element.isSelected()) {
            element.click();
            if (element.isSelected()) {
                countFailedCheckboxes.add(++i);
            }
        }
    }
    public void unSelectCheckbox(WebElement element1, WebElement element2) {
        if (element1.isSelected()) {
            element1.click();
            if (element1.isSelected()) {
                countFailedCheckboxes.add(++i);
            }
        }
        if (element2.isSelected()) {
            element2.click();
            if (element2.isSelected()) {
                countFailedCheckboxes.add(++i);
            }
        }
    }
    public void countIfFailToSelect(WebElement element1, WebElement element2) {
        if (!(element1.isSelected())) {
            countFailedCheckboxes.add(++i);
        }
        if (!(element2.isSelected())) {
            countFailedCheckboxes.add(++i);
        }
    }
    public void countIfFailToUnSelect(WebElement element1, WebElement element2) {
        if (element1.isSelected()) {
            countFailedCheckboxes.add(++i);
        }
        if (element2.isSelected()) {
            countFailedCheckboxes.add(++i);
        }
    }
}
