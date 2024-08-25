package org.example.tests;

import org.example.page.pageFactory.LoginPage_PF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestVWOLogin_PF {



    @Test
    public void loginVWONegativeTest() throws IOException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        LoginPage_PF loginPagePf = new LoginPage_PF(driver);
        String error_msg = loginPagePf.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");
        driver.quit();
    }


}
