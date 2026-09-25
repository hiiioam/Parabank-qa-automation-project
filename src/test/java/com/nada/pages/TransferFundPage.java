package com.nada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundPage {
    private WebDriver driver;

    public TransferFundPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openTransferPage(){
        this.driver.get("http://localhost:8080/parabank/transfer.htm");
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#fromAccountId option"), 0));
    }

    public void selectSourceAccount(String idSourceAccount){
        WebElement element = this.driver.findElement(By.id("fromAccountId"));
        Select selectSource = new Select(element);
        selectSource.selectByValue(idSourceAccount);
    }

    public void selectDestinationAccount(String idDestinationAccount) {
        WebElement element = this.driver.findElement(By.id("toAccountId"));
        Select selectDestination = new Select(element);
        selectDestination.selectByValue(idDestinationAccount);
    }

    public void saisirMontant(String montant) {
        this.driver.findElement(By.id("amount"))
                .sendKeys(montant);
    }

    public void clickOnTransfer(){
        this.driver.findElement(By.cssSelector("input.button[value='Transfer']"))
                .click();
    }

    public String getMessageSucces() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#showResult h1.title")));
        return this.driver.findElement(By.cssSelector("#showResult h1.title")).getText();
    }
}
