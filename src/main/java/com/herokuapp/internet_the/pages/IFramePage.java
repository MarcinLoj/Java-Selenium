package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage extends TestBase {
    public String inputContent = "some random words in case to check user can send keys to iFrame";
    public String beginningInputContent = "Your content goes here.";
    public int increaseCount;
    public int decreaseCount;
    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    public WebElement pageHeader;
    @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
    public WebElement textInput;
    @FindBy(xpath = "//button[@aria-label=\"Undo\" and @aria-disabled=\"false\"]")
    public WebElement undoButton;
    @FindBy(xpath = "//button[@aria-label=\"Undo\" and @aria-disabled=\"true\"]")
    public WebElement undoButtonDisabled;
    @FindBy(xpath = "//button[@aria-label=\"Redo\" and @aria-disabled=\"false\"]")
    public WebElement redoButton;
    @FindBy(xpath = "//button[@aria-label=\"Redo\" and @aria-disabled=\"true\"]")
    public WebElement redoButtonDisabled;
    @FindBy(xpath = "//button[@aria-label=\"Bold\" and @aria-pressed=\"false\"]")
    public WebElement boldButton;
    @FindBy(xpath = "//button[@aria-label=\"Bold\" and @aria-pressed=\"true\"]")
    public WebElement boldButtonDisabled;
    @FindBy(xpath = "//button[@aria-label=\"Italic\" and @aria-pressed=\"false\"]")
    public WebElement italicButton;
    @FindBy(xpath = "//button[@aria-label=\"Italic\" and @aria-pressed=\"true\"]")
    public WebElement italicButtonDisabled;
    @FindBy(xpath = "//span[@class=\"tox-tbtn__select-label\"]")
    public WebElement formatInformation;
    @FindBy(xpath = "//*[@id=\"tinymce\"]//strong")
    public WebElement textInputBold;
    @FindBy(xpath = "//*[@id=\"tinymce\"]//em")
    public WebElement textInputItalic;
    @FindBy(xpath = "//button[@aria-label=\"Align left\" and @aria-pressed=\"false\"]")
    public WebElement textLeftAlignButton;
    @FindBy(xpath = "//button[@aria-label=\"Align center\" and @aria-pressed=\"false\"]")
    public WebElement textCenterAlignButton;
    @FindBy(xpath = "//button[@aria-label=\"Align right\" and @aria-pressed=\"false\"]")
    public WebElement textRightAlignButton;
    @FindBy(xpath = "//button[@aria-label=\"Justify\" and @aria-pressed=\"false\"]")
    public WebElement textJustifyButton;
    @FindBy(xpath = "//button[@aria-label=\"Align left\" and @aria-pressed=\"true\"]")
    public WebElement textLeftAlignButtonDisabled;
    @FindBy(xpath = "//button[@aria-label=\"Align center\" and @aria-pressed=\"true\"]")
    public WebElement textCenterAlignButtonDisabled;
    @FindBy(xpath = "//button[@aria-label=\"Align right\" and @aria-pressed=\"true\"]")
    public WebElement textRightAlignButtonDisabled;
    @FindBy(xpath = "//button[@aria-label=\"Justify\" and @aria-pressed=\"true\"]")
    public WebElement textJustifyButtonDisabled;
    @FindBy(xpath = "//button[@aria-label=\"Increase indent\" and @aria-disabled=\"false\"]")
    public WebElement increaseIndentButton;
//    @FindBy(xpath = "//button[@aria-label=\"Increase indent\" and @aria-disabled=\"true\"]")
//    public WebElement increaseIndentButtonDisabled;
    @FindBy(xpath = "//button[@aria-label=\"Decrease indent\" and @aria-disabled=\"false\"]")
    public WebElement decreaseIndentButton;
    @FindBy(xpath = "//button[@aria-label=\"Decrease indent\" and @aria-disabled=\"true\"]")
    public WebElement decreaseIndentButtonDisabled;

    public IFramePage() {
        PageFactory.initElements(driver,this);
    }
    public void switchFrame() {
        driver.switchTo().frame("mce_0_ifr");
    }
    public String getTextFrom(WebElement element) {
        return element.getText();
    }
    public void clearTextInput() {
        switchFrame();
        textInput.clear();
    }
    public void sendKeysToTextInput() {
        clearTextInput();
        textInput.sendKeys(inputContent);
    }
    public void undoChanges() {
        while(!(textInput.getText().equals(beginningInputContent))) {
            driver.switchTo().defaultContent();
            undoButton.click();
            switchFrame();
        }
    }
    public void redoChanges() {
        while(!(textInput.getText().equals(inputContent))) {
            driver.switchTo().defaultContent();
            redoButton.click();
            switchFrame();
        }
    }
    public boolean checkButtonAvailability(WebElement element) {
        driver.switchTo().defaultContent();
        return element.isDisplayed();
    }
    public boolean checkTextInputType(WebElement element) {
        switchFrame();
        return element.isDisplayed();
    }
    public boolean checkTextInputType(WebElement element, WebElement element2) {
        switchFrame();
        return (element.isDisplayed() && element2.isDisplayed());
    }
    public void clickButton(WebElement element) {
        driver.switchTo().defaultContent();
        while (element.isDisplayed()) {
            element.click();
        }
    }
    public void highlightText() {
        textInput.sendKeys(Keys.LEFT_CONTROL + "A");
    }
    public boolean checkIsTextAlignedTo(String alignTo) {
        switchFrame();
        return driver.findElement(By.xpath("//*[@id=\"tinymce\"]//p[@style=\"text-align: "+alignTo+";\"]")).isDisplayed();
    }
    public boolean checkIsIndentIncreased() {
        switchFrame();
        return driver.findElement(By.xpath("//*[@id=\"tinymce\"]//p[@style=\"padding-left: "+increaseCount*40+"px;\"]")).isDisplayed();
    }
    public boolean checkIsIndentDecreased() {
        switchFrame();
        int count = increaseCount - decreaseCount;
        if(count >= 1) {
            return driver.findElement(By.xpath("//*[@id=\"tinymce\"]//p[@style=\"padding-left: "+count*40+"px;\"]")).isDisplayed();
        }
        else
            return driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).isDisplayed();
    }
    public void clickIncreaseButton(Integer clickCount) {
        this.increaseCount = clickCount;
        for(int i = 0; i < clickCount; i++) {
            increaseIndentButton.click();
        }
    }
    public void clickDecreaseButton(Integer clickCount) {
        this.decreaseCount = clickCount;
        for(int i = 0; i < clickCount; i++) {
            decreaseIndentButton.click();
        }
    }
}
