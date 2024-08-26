package org.example.tests;

import org.apache.logging.log4j.*;
import org.example.page.pageFactory.LoginPage_PF;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static org.example.driver.DriverManager.*;

public class TestVWOLogin_PF_DM_UAT {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF_DM_UAT.class.getName());


    @BeforeTest
    public void startBrowser(){
        init();
    }

    @Test
    public void loginVWONegativeTest() throws IOException {

        logger.info("Start Logging");

        LoginPage_PF loginPagePf = new LoginPage_PF(driver);
        loginPagePf.openVWOLoginURL("uat");
        String error_msg = loginPagePf.loginToVWOInvalidCreds();
        logger.info("Verifying the Result");
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

    }

    @AfterTest
    public void closeBrowser(){
        down();
    }
}
