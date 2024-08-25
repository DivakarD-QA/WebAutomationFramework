package org.example.tests;

import org.example.page.pageObject.LoginPage_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin_POM {


    @Test
    public void loginVWONegativeTest(){
        
        WebDriver driver = new EdgeDriver();
        LoginPage_POM loginPage = new LoginPage_POM(driver);
        String error_msg = loginPage.loginVWOInvalidCred("admin", "bsywgde6");
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");
        driver.quit();
    }

    @Test
    public void loginVWONegativeTest2(){
        WebDriver driver = new EdgeDriver();
        LoginPage_POM loginPage = new LoginPage_POM(driver);
        String error_msg = loginPage.loginVWOInvalidCred("admin@gmail.com", "bsywgde6");
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");
        driver.quit();
    }


}
