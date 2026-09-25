package com.nada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillPaymentPage {
    WebDriver driver;

    public BillPaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBillPayment() {
        this.driver.get("http://localhost:8080/parabank/billpay.htm");
    }

    public void saisirInfos(
            String payeeName,
            String address,
            String city,
            String state,
            String zipCode,
            String phone,
            String account,
            String verifyAccount,
            String amount,
            String fromAccount) {

        this.driver.findElement(By.name("payee.name"))
                .sendKeys(payeeName);

        this.driver.findElement(By.name("payee.address.street"))
                .sendKeys(address);

        this.driver.findElement(By.name("payee.address.city"))
                .sendKeys(city);

        this.driver.findElement(By.name("payee.address.state"))
                .sendKeys(state);

        this.driver.findElement(By.name("payee.address.zipCode"))
                .sendKeys(zipCode);
        this.driver.findElement(By.name("payee.phoneNumber"))
                .sendKeys(phone);
        this.driver.findElement(By.name("payee.accountNumber"))
                .sendKeys(account);
        this.driver.findElement(By.name("verifyAccount"))
                .sendKeys(verifyAccount);
        this.driver.findElement(By.name("amount"))
                .sendKeys(amount);

        WebElement selectElement = this.driver.findElement(By.name("fromAccountId"));
        Select selectAccountID = new Select(selectElement);
        selectAccountID.selectByValue(fromAccount);
    }

    public void clickOnSendPayment() {
        this.driver.findElement(By.cssSelector("input.button[value='Send Payment']"))
                .click();
    }

    public String getErrorNameVide() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validationModel-name")));
        return this.driver.findElement(By.id("validationModel-name")).getText();
    }

    public String getErrorAddress() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validationModel-address")));
        return this.driver.findElement(By.id("validationModel-address")).getText();
    }

    public String getErrorCity() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validationModel-city")));
        return this.driver.findElement(By.id("validationModel-city")).getText();
    }

    public String getErrorState() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validationModel-state")));
        return this.driver.findElement(By.id("validationModel-state")).getText();
    }

    public String getErrorZipCode() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validationModel-zipCode")));
        return this.driver.findElement(By.id("validationModel-zipCode")).getText();
    }

    public String getErrorEmptyAccount() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validationModel-account-empty")));
        return this.driver.findElement(By.id("validationModel-account-empty")).getText();
    }

    public String getErrorVerifyAccount() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validationModel-verifyAccount-empty")));
        return this.driver.findElement(By.id("validationModel-verifyAccount-empty")).getText();
    }

    public String getErrorAmountEmpty() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validationModel-amount-empty")));
        return this.driver.findElement(By.id("validationModel-amount-empty")).getText();
    }

    public String getErrorAccountMismatch() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validationModel-verifyAccount-mismatch")));
        return this.driver.findElement(By.id("validationModel-verifyAccount-mismatch")).getText();
    }

    public String getErrorAmountInvalid() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validationModel-amount-invalid")));
        return this.driver.findElement(By.id("validationModel-amount-invalid")).getText();
    }

    public String getMsgSucces() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#billpayResult .title")));
        return this.driver.findElement(By.cssSelector("#billpayResult .title")).getText();
    }





}
