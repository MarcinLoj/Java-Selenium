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
    @FindBy(css = "#content > ul > li:nth-child(7) > a")
    public WebElement contextMenuHyperLink;
    @FindBy(css = "#content > ul > li:nth-child(8) > a")
    public WebElement digestAuthenticationHyperLink;
    @FindBy(css = "#content > ul > li:nth-child(9) > a")
    public WebElement disappearingElementsHyperLink;
    @FindBy(css = "#content > ul > li:nth-child(11) > a")
    public WebElement dropdownHyperLink;
    @FindBy(css = "#content > ul > li:nth-child(13) > a")
    public WebElement dynamicControlsHyperLink;
    @FindBy(css = "#content > ul > li:nth-child(14) > a")
    public WebElement dynamicLoadingHyperLink;
    @FindBy(css = "#content > ul > li:nth-child(15) > a")
    public WebElement entryAdHyperLink;
    @FindBy(css = "#content > ul > li:nth-child(16) > a")
    public WebElement exitIntentHyperLink;
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
    public ChallengingDOMPage navigateToChallengingDOMPage() {
        waitUntilVisibilityOfElement(challengingDOMHyperLink);
        challengingDOMHyperLink.click();
        return new ChallengingDOMPage();
    }
    public CheckboxPage navigateToCheckboxPage() {
        waitUntilVisibilityOfElement(checkboxHyperLink);
        checkboxHyperLink.click();
        return new CheckboxPage();
    }
    public ContextMenuPage navigateToContextMenuPage() {
        waitUntilVisibilityOfElement(contextMenuHyperLink);
        contextMenuHyperLink.click();
        return new ContextMenuPage();
    }
    public DigestAuthenticationPage navigateToDigestAuthenticationPage() {
        waitUntilVisibilityOfElement(digestAuthenticationHyperLink);
        digestAuthenticationHyperLink.click();
        return new DigestAuthenticationPage();
    }
    public DisappearingElementsPage navigateToDisappearingElementsPage() {
        waitUntilVisibilityOfElement(disappearingElementsHyperLink);
        disappearingElementsHyperLink.click();
        return new DisappearingElementsPage();
    }
    public DropdownPage navigateToDropdownPage() {
        waitUntilVisibilityOfElement(dropdownHyperLink);
        dropdownHyperLink.click();
        return new DropdownPage();
    }
    public DynamicControlsPage navigateToDynamicControlsPage() {
        waitUntilVisibilityOfElement(dynamicControlsHyperLink);
        dynamicControlsHyperLink.click();
        return new DynamicControlsPage();
    }
    public DynamicLoadingPage navigateToDynamicLoadingPage() {
        waitUntilVisibilityOfElement(dynamicLoadingHyperLink);
        dynamicLoadingHyperLink.click();
        return new DynamicLoadingPage();
    }
    public EntryAdPage navigateToEntryAdPage() {
        waitUntilVisibilityOfElement(entryAdHyperLink);
        entryAdHyperLink.click();
        return new EntryAdPage();
    }
    public ExitIntentPage navigateToExitIntentPage() {
        waitUntilVisibilityOfElement(exitIntentHyperLink);
        exitIntentHyperLink.click();
        return new ExitIntentPage();
    }
}
