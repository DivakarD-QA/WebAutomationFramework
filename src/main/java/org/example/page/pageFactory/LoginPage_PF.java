package org.example.page.pageFactory;

import org.example.base.CommonToAllPage;
import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPage_PF extends CommonToAllPage {

    WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    // Page Locators

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;

    // Page Actions
    public String loginToVWOInvalidCreds() throws IOException {
        enterInput(username, PropertyReader.readKey("invalid_username"));
        enterInput(password, PropertyReader.readKey("invalid_password"));
        clickElement(signButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return error_message.getText();
    }

}
