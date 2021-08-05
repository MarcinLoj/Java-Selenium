package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends TestBase {
    @FindBy(xpath = "//*[@id=\"content\"]/div/a[1]")
    public WebElement elementOnPageThatIsHiddenHyperLink;
    @FindBy(xpath = "//*[@id=\"content\"]/div/a[2]")
    public WebElement elementRenderedAfterTheFact;

    public DynamicLoadingPage() {
        PageFactory.initElements(driver,this);
    }
    public DynamicLoadingPage1 navigateToDynamicLoadingPage1() {
        waitUntilVisibilityOfElement(elementOnPageThatIsHiddenHyperLink);
        elementOnPageThatIsHiddenHyperLink.click();
        return new DynamicLoadingPage1();
    }
    public DynamicLoadingPage2 navigateToDynamicLoadingPage2() {
        waitUntilVisibilityOfElement(elementRenderedAfterTheFact);
        elementRenderedAfterTheFact.click();
        return new DynamicLoadingPage2();
    }
    public boolean verifyUserNavigatedToLoadingPage1() {
        return (driver.getCurrentUrl().equals("http://the-internet.herokuapp.com/dynamic_loading/1"));
    }
    public boolean verifyUserNavigatedToLoadingPage2() {
        return (driver.getCurrentUrl().equals("http://the-internet.herokuapp.com/dynamic_loading/2"));
    }
}
