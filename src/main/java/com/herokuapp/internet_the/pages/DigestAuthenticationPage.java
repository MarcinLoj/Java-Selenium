package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigestAuthenticationPage extends TestBase {
    public String digestAuthAuthenticate = "http://admin:admin@the-internet.herokuapp.com/digest_auth";
    @FindBy(css = "#content > div > h3")
    public WebElement digestAuthMessageLocator;
    public DigestAuthenticationPage() {
        PageFactory.initElements(driver,this);
    }
    public void userBypassDigestAuthenticator() {
        driver.get(digestAuthAuthenticate);
    }
}
