package com.nada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenNewAccount {
    private WebDriver driver;

    public OpenNewAccount(WebDriver driver) {
        this.driver = driver;
    }
    public void openNAPage() {
        this.driver.get("http://localhost:8080/parabank/openaccount.htm");
    }

    public void selectTypeAccount(String type) {
        WebElement selectElement = this.driver.findElement(By.id("type"));
        Select selectType = new Select(selectElement);
        selectType.selectByValue(type);
    }

    public void selectSourceAccount(String account) {
        WebElement accountElement = this.driver.findElement(By.id("fromAccountId"));
        System.out.println("element: "+accountElement);
        Select selectAccount = new Select(accountElement);
        selectAccount.selectByValue(account);
    }

    public void clickOnOpen(){
        this.driver.findElement(By.cssSelector("input.button[value='Open New Account']"))
                .click();
    }

    public String checkSuccess() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#openAccountResult .title")));
        return this.driver.findElement(By.cssSelector("#openAccountResult .title")).getText();
    }
}
