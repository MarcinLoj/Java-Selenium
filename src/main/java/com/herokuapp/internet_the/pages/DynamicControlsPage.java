package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DynamicControlsPage extends TestBase {
    @FindBy(xpath = "//*[@id=\"checkbox-example\"]/button[contains(text(),'Remove')]")
    public WebElement removeButton;
    @FindBy(xpath = "//*[@id=\"message\" and contains(text(),\"It's gone\")]")
    public WebElement confirmRemovedMessage;
    @FindBy(xpath = "//*[@id=\"checkbox-example\"]/button[contains(text(),'Add')]")
    public WebElement addButton;
    @FindBy(xpath = "//*[@id=\"message\" and contains(text(),\"It's back\")]")
    public WebElement confirmAddedMessage;
    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    public WebElement checkbox;
    @FindBy(xpath = "//*[@id=\"message\" and contains(text(),\"It's disabled!\")]")
    public WebElement disabledMessage;
    @FindBy(xpath = "//*[@id=\"message\" and contains(text(),\"It's enabled!\")]")
    public WebElement enabledMessage;
    @FindBy(xpath = "//*[@id=\"input-example\"]/button[contains(text(),\"Disable\")]")
    public WebElement disableButton;
    @FindBy(xpath = "//*[@id=\"input-example\"]/button[contains(text(),\"Enable\")]")
    public WebElement enableButton;
    @FindBy(xpath = "//*[@id=\"loading\" and contains(text(),\"Wait for it...\")]")
    public WebElement loadingBar;
    public DynamicControlsPage() {
        PageFactory.initElements(driver,this);
    }

    public void clickAddButton() {
        waitUntilVisibilityOfElement(addButton);
        addButton.click();
        waitUntilVisibilityOfElement(confirmAddedMessage);
    }
    public void clickToAddCheckbox() {
        if (!(checkbox.isSelected()))
            checkbox.click();
    }
    public boolean verifyIsCheckboxAdded() {
        return confirmAddedMessage.isDisplayed();
    }
    public void clickRemoveButton() {
        waitUntilVisibilityOfElement(removeButton);
        removeButton.click();
        waitUntilVisibilityOfElement(confirmRemovedMessage);
    }
    public boolean verifyIsCheckboxRemoved() {
        return confirmRemovedMessage.isDisplayed();
    }
    public void clickEnableButton() {
        waitUntilVisibilityOfElement(enableButton);
        enableButton.click();
        waitUntilVisibilityOfElement(enabledMessage);
    }
    public boolean verifyIsEnableButtonClickable() {
        return enabledMessage.isDisplayed();
    }
    public void clickDisableButton() {
        waitUntilVisibilityOfElement(disableButton);
        disableButton.click();
        waitUntilVisibilityOfElement(disabledMessage);
    }
    public boolean verifyIsDisableButtonClickable() {
        return disabledMessage.isDisplayed();
    }
    public boolean verifyIsCheckboxSelected() {
        return checkbox.isSelected();
    }
}
