package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends TestBase {
    @FindBy(id = "dropdown")
    public WebElement dropDownListButton;
    public Select select;

    public DropdownPage() {
        PageFactory.initElements(driver,this);
    }
    public void chooseOptionFromDropdownList(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }
    public int countSelectedOptions() {
        return select.getAllSelectedOptions().size();
    }
}
