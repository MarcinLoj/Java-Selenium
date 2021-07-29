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
    @FindBy(css = "#content > ul > li:nth-child(4) > a")
        public WebElement brokenImagesHyperLink;
    @FindBy(css = "#content > ul > li:nth-child(5) > a")
    public WebElement challengingDOMHyperLink;
    @FindBy(css = "#content > ul > li:nth-child(6) > a")
    public WebElement checkboxHyperLink;

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
    public BrokenImagesPage navigateToBrokenImagesPage() {
        waitUntilVisibilityOfElement(brokenImagesHyperLink);
        brokenImagesHyperLink.click();
        return new BrokenImagesPage();
    }
    public ChallengingDOMPage navigateToChallengingDOM() {
        waitUntilVisibilityOfElement(challengingDOMHyperLink);
        challengingDOMHyperLink.click();
        return new ChallengingDOMPage();
    }
    public CheckboxPage navigateToCheckboxPage() {
        waitUntilVisibilityOfElement(checkboxHyperLink);
        checkboxHyperLink.click();
        return new CheckboxPage();
    }
}
