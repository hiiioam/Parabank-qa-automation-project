package com.nada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void open(){
        this.driver.get("http://localhost:8080/parabank/index.htm");
    }



    public void enterUsername(String username){
        driver.findElement(By.name("username"))
                .sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(By.name("password"))
                .sendKeys(password);
    }

    public void clickOnLogin(){
        driver.findElement(By.cssSelector("input.button[value='Log In']"))
                .click();
    }

    public String getErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error")));
        return this.driver.findElement(By.cssSelector(".error")).getText();

    }

}
