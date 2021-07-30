package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends TestBase {
    @FindBy(css = "#hot-spot")
    public WebElement contextMenu;
    public ContextMenuPage() {
        PageFactory.initElements(driver,this);
    }
    public void rightClickOnContextMenu() {
        Actions action = new Actions(driver);
        action.contextClick(contextMenu).build().perform();
    }
    public String getAlertMessage() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}
