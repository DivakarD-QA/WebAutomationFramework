package org.example.base;

import org.example.driver.DriverManager;
import org.example.driver.DriverManagerTL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class CommonToAllTest {
    // To call the Start the Webdriver
    // Down the WebDriver
    // Start Webdirver start


    @BeforeMethod
    public void setup() throws MalformedURLException {
        DriverManager.init();
//        DriverManagerTL.init();
//        DriverManagerSelenoid.init();
    }

    @AfterMethod
    public void tearDown() throws MalformedURLException {
        DriverManager.down();
//        DriverManagerTL.down();
//        DriverManagerSelenoid.down();
    }
}
