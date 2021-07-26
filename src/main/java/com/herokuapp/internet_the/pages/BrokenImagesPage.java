package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenImagesPage extends TestBase {
    List<WebElement> brokenImagesList = new ArrayList<>();
    List<Integer> brokenImagesStatusList = new ArrayList<>();

    public void displayBrokenImages() {
        for(int i = 0; i < brokenImagesList.size(); i++) {
            System.out.print("Image: " + brokenImagesList.get(i) + " and Response Status Code: ");
            System.out.print(brokenImagesStatusList.get(i) + "\n");
        }
    }

    public boolean verifyIsBroken() {
        return brokenImagesList.isEmpty();
        }

    public void isImageBroken() throws IOException {
        List<WebElement> images = driver.findElements(By.tagName("img"));
        for (WebElement image : images) {
            String imageSrc = image.getAttribute("src");
            HttpURLConnection connection = (HttpURLConnection) new URL(imageSrc).openConnection();
            connection.connect();
            int responseStatus = connection.getResponseCode();
            connection.disconnect();
            if (responseStatus != 200) {
                brokenImagesList.add(image);
                brokenImagesStatusList.add(responseStatus);
            }
        }
    }
}
