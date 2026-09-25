package com.nada.steps;

import com.nada.pages.LoginPage;
import com.nada.pages.TransferFundPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferSteps {
    TransferFundPage transferPage;



    @Given("l'utilisateur est connecté")
    public void utilisateurDoitSeConnecter() {
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.open();
        loginPage.enterUsername("nada");
        loginPage.enterPassword("password");
        loginPage.clickOnLogin();

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Accounts Overview"));
    }

    @And("l'utilisateur est sur la page Transfer Funds")
    public void utilisateurAccedePageTransferFunds() {
        transferPage = new TransferFundPage(Hooks.driver);
        transferPage.openTransferPage();
    }

    @When("l'utilisateur saisit le montant {string}")
    public void utilisateurSaisitMontant(String montant) {
        transferPage.saisirMontant(montant);

    }

    @And("l'utilisateur sélectionne {string} comme compte source")
    public void utilisateurSelectionneCompteSource(String sourceAccount) {
        transferPage.selectSourceAccount(sourceAccount);

    }

    @And("l'utilisateur sélectionne {string} comme compte destination")
    public void utilisateurSelectionneCompteDestination(String destinationAccount) {
        transferPage.selectDestinationAccount(destinationAccount);
    }

    @And("l'utilisateur clique sur le bouton Transfer")
    public void utilisateurCliqueTransfer() {
        transferPage.clickOnTransfer();
    }

    @Then("l'utilisateur voit message succès")
    public void utilisateurVoitMsgSucces() {
        String message = transferPage.getMessageSucces();
        Assertions.assertEquals("Transfer Complete!",message);
    }
}
