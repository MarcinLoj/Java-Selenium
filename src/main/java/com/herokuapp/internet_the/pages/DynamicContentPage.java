package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPage extends TestBase {
    @FindBy(css = "#content > div > p:nth-child(3) > a")
    public WebElement staticContentHyperLink;

    public DynamicContentPage() {
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> listBeforeReload;
    public List<WebElement> listAfterReload;
    public List<Integer> compareTwoListsHelper = new ArrayList<>();

    public void displayEqualContentFromList(List<WebElement> before, List <WebElement> after, List <Integer> helper) {
        int i = (after.size() - 1);
        for(int j = 0; j < after.size(); j++) {
            if (before.get(i).equals(after.get(i))) {
                helper.add(j + 1);
                --i;
            }
            else
                --i;
        }
    }

    public void checkIsContentChanging() {
        listBeforeReload = driver.findElements(By.xpath("//div[@id=\"content\"]//div[@id=\"content\"]//div//div"));
        driver.navigate().refresh();
        listAfterReload = driver.findElements(By.xpath("//div[@id=\"content\"]//div[@id=\"content\"]//div//div"));
        displayEqualContentFromList(listBeforeReload,listAfterReload,compareTwoListsHelper);
    }
    public boolean verifyIsChanged() {
        return compareTwoListsHelper.isEmpty();
    }
    public StaticContentPage navigateToStaticContentPage() {
        staticContentHyperLink.click();
        return new StaticContentPage();
    }
}
