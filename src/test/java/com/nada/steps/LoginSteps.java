package com.nada.steps;

import com.nada.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    private LoginPage loginPage;

    @Given("l'utilisateur est sur la page de connexion")
    public void utilisateurSurLaPagedeConnexion() throws InterruptedException {
        loginPage = new LoginPage(Hooks.driver);
        loginPage.open();
    }

    @When("il saisit un nom d'utilisateur et un mot de passe valides")
    public void utilisateurSaisitUsernameEtPassword() {
        loginPage.enterUsername("nada");
        loginPage.enterPassword("password");

    }

    @And("il clique sur login")
    public void utilisateurCliqueSurLogin(){
        loginPage.clickOnLogin();
    }

    @Then("il doit accéder à la page Accounts overview")
    public void utilisateurAccedeAccountsOverview() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#showOverview .title")));
        Assertions.assertEquals("ParaBank | Accounts Overview", Hooks.driver.getTitle());

    }



    @When("il saisit {string} et {string}")
    public void utilisateurSaisitUsernameIncorrectOrPasswordIncorrect(String username, String password) throws InterruptedException {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }


    @Then("il doit voir la page erreur")
    public void utilisateurAccedePageErreur(){
        String message = loginPage.getErrorMessage();
        Assertions.assertEquals("The username and password could not be verified.",message);
    }


}
