package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage extends TestBase {
    @FindBy(xpath = "//li[2]//a")
    public WebElement iFrameHyperLink;
    public FramesPage() {
        PageFactory.initElements(driver,this);
    }
    public IFramePage navigateToiFramePage() {
        waitUntilVisibilityOfElement(iFrameHyperLink);
        iFrameHyperLink.click();
        return new IFramePage();
    }
}
