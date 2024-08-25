package org.example.base;

import org.example.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {
    // To call the Start the Webdriver
    // Down the WebDriver
    // Start Webdirver start
    @BeforeMethod
    public void setup(){
        DriverManager.init();
//        DriverManagerSelenoid.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
//        DriverManagerSelenoid.down();
    }
}