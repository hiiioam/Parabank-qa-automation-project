package com.nada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSignUp(){
        this.driver.get("http://localhost:8080/parabank/register.htm");
    }

    public void entrerInformations(String firstName,
                                  String lastName,
                                  String address,
                                  String city,
                                  String state,
                                  String zipCode,
                                  String phone,
                                  String ssn,
                                  String username,
                                  String password,
                                  String confirmPassword){
        this.driver.findElement(By.id("customer.firstName"))
                .sendKeys(firstName);

        this.driver.findElement(By.id("customer.lastName"))
                .sendKeys(lastName);

        this.driver.findElement(By.id("customer.address.street"))
                .sendKeys(address);

        this.driver.findElement(By.id("customer.address.city"))
                .sendKeys(city);

        this.driver.findElement(By.id("customer.address.state"))
                .sendKeys(state);

        this.driver.findElement(By.id("customer.address.zipCode"))
                .sendKeys(zipCode);

        this.driver.findElement(By.id("customer.phoneNumber"))
                .sendKeys(phone);

        this.driver.findElement(By.id("customer.ssn"))
                .sendKeys(ssn);

        this.driver.findElement(By.id("customer.username"))
                .sendKeys(username);

        this.driver.findElement(By.id("customer.password"))
                .sendKeys(password);

        this.driver.findElement(By.id("repeatedPassword"))
                .sendKeys(confirmPassword);


    }

    public void clickOnRegister() {
        this.driver.findElement(By.cssSelector("input.button[value='Register']"))
                .click();
    }

    public String getMessageErreurPassword() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("repeatedPassword.errors")));
        return this.driver.findElement(By.id("repeatedPassword.errors")).getText();
    }

    public String getMessageErreurUsername() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer.username.errors")));
        return this.driver.findElement(By.id("customer.username.errors")).getText();
    }

}
