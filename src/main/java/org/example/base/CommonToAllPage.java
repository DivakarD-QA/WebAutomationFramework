package org.example.base;

import org.example.driver.DriverManager;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.example.driver.DriverManager.getDriver;

public class CommonToAllPage {


    public CommonToAllPage(){
        // If you want to call something before every Page Object Class call, Put your Code here");
        // Open File, Open Data Base Connection You can write code here
    }

    public void openVWOLoginURL(String URL) throws IOException {
        switch (URL){
            case "qa":
                getDriver().get(PropertyReader.readKey("qa_url"));
                break;
            case "uat":
                getDriver().get(PropertyReader.readKey("uat_url"));
                break;
            default:
                getDriver().get(PropertyReader.readKey("url"));

        }

    }


    public void clickElement(By by){
        getDriver().findElement(by).click();
    }
    public void clickElement(WebElement by){
        by.click();
    }
    public void enterInput(By by, String key){
        getDriver().findElement(by).sendKeys(key);
    }
    public void enterInput(WebElement element, String key){
        element.sendKeys(key);
    }

    //Wait
    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public  WebElement getElement(By key) {
         return getDriver().findElement(key);
    }

    public WebElement getElement(WebElement element) {
        return element;
    }

    public void iWaitForElementToBeVisible(WebElement loc,String url) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfAllElements(loc));
            wait.until(ExpectedConditions.urlContains(url));
        } catch (Exception e) {
            System.out.println("Failed to Wait!: " + e.toString());
        }
    }


}
