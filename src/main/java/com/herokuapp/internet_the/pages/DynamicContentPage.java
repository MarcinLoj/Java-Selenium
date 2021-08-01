package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPage extends TestBase {
    public List<WebElement> textBeforeReload;
    public List<WebElement> textAfterReload;
    public List<WebElement> photoBeforeReload;
    public List<WebElement> photoAfterReload;
    public List<Integer> comparePhotos = new ArrayList<>();
    public List<Integer> compareTexts = new ArrayList<>();

    public DynamicContentPage() {
        PageFactory.initElements(driver,this);
    }
    public void checkContentChanges() {
        textBeforeReload = driver.findElements(By.xpath("//*[@id=\"content\"]//*[@class=\"large-10 columns\"]"));
        photoBeforeReload = driver.findElements(By.xpath("//*[@id=\"content\"]//*[@class=\"large-2 columns\"]"));
        driver.navigate().refresh();
        textAfterReload = driver.findElements(By.xpath("//*[@id=\"content\"]//*[@class=\"large-10 columns\"]"));
        photoAfterReload = driver.findElements(By.xpath("//*[@id=\"content\"]//*[@class=\"large-2 columns\"]"));
        displayEqualContentFromList(photoBeforeReload,photoAfterReload,comparePhotos);
        displayEqualContentFromList(textBeforeReload,textAfterReload,compareTexts);
    }
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
    public boolean verifyIsChanged() {
        return (compareTexts.isEmpty() && comparePhotos.isEmpty());
    }
}
