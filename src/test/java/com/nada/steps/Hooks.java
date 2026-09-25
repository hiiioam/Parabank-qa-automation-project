package com.nada.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public static WebDriver driver;



    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("prefs", java.util.Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_leak_detection", false
        ));
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown(){
        driver.quit();
    }



}
