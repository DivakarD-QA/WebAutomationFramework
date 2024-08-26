package org.example.page.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_POM {
    // Contains
    // Page Locators
    // Page Action

    WebDriver driver;

    public LoginPage_POM(WebDriver driver){
        this.driver = driver;
    }
    // private means we are encapsulating
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    public String loginVWOInvalidCred(String user, String pwd){

        driver.get("https://app.vwo.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(error_message));


        String error_msg = driver.findElement(error_message).getText();

        return error_msg;
    }
}
