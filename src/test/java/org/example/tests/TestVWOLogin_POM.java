package org.example.tests;

import org.example.page.pageObject.LoginPage_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestVWOLogin_POM {

    @BeforeTest
    public void setup(){
//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--disable-gpu");
//        WebDriver driver = new EdgeDriver(options);


    }

    @Test
    public void loginVWONegativeTest(){

        WebDriver driver = new ChromeDriver();
        LoginPage_POM loginPage = new LoginPage_POM(driver);
        String error_msg = loginPage.loginVWOInvalidCred("admin", "bsywgde6");
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");
        driver.quit();
    }

    @Test
    public void loginVWONegativeTest2(){
        WebDriver driver = new ChromeDriver();
        LoginPage_POM loginPage = new LoginPage_POM(driver);
        String error_msg = loginPage.loginVWOInvalidCred("admin@gmail.com", "bsywgde6");
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");
        driver.quit();
    }


}
