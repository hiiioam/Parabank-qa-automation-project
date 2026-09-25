package com.nada.steps;

import com.nada.pages.LoginPage;
import com.nada.pages.OpenNewAccount;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenNewAccountSteps {
    OpenNewAccount openNewAccount;


//    @Given("l'utilisateur est connecté")
//    public void userConnected() {
//        LoginPage loginPage = new LoginPage(Hooks.driver);
//        loginPage.open();
//        loginPage.enterUsername("nada");
//        loginPage.enterPassword("password");
//        loginPage.clickOnLogin();
//        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.titleContains("Accounts Overview"));
//    }

    @And("l'utilisateur accède à la page pour ouvrir un nouveau compte")
    public void userAccedeOpenAccountPage() {
        openNewAccount = new OpenNewAccount(Hooks.driver);
        openNewAccount.openNAPage();
    }

    @When("l'utilisateur sélectionne le type de compte SAVINGS de valeur {string}")
    public void userSelectTypeAccount(String type){
        openNewAccount.selectTypeAccount(type);
    }

    @And("l'utilisateur sélectionne le compte source {string} pour déposer 100 dans le nouveau compte")
    public void userSelectSourceAccount(String source) {
        openNewAccount.selectSourceAccount(source);
    }

    @And("l'utilisateur clique sur le bouton Open New Account")
    public void clickOnOpenAccount() {
        openNewAccount.clickOnOpen();
    }

    @Then("on affiche une page qui indique l'opération a réussi")
    public void afficherPageSucces() {
        String message = openNewAccount.checkSuccess();
        Assertions.assertEquals("Account Opened!", message);
    }
}
