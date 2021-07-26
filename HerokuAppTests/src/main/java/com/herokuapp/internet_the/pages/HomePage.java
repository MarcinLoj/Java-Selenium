package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(css = "#content > ul > li:nth-child(2) > a")
        public WebElement addRemoveElementsHyperLink;
    @FindBy(css = "#content > ul > li:nth-child(3) > a")
        public WebElement basicAuthHyperLink;

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    public AddRemoveElementsPage navigateToAddRemoveElementsPage() {
        waitUntilVisibilityOfElement(addRemoveElementsHyperLink);
        addRemoveElementsHyperLink.click();
        return new AddRemoveElementsPage();
    }
    public BasicAuthPage navigateToBasicAuthPage() {
        waitUntilVisibilityOfElement(basicAuthHyperLink);
        basicAuthHyperLink.click();
        return new BasicAuthPage();
    }
}
