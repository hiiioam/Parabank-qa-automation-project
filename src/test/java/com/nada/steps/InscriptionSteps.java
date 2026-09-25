package com.nada.steps;

import com.nada.pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class InscriptionSteps {
    SignUpPage signUpPage;

    @Given("l'utilisateur est sur la page d'inscription")
    public void utilisateurSurPageInscription() {
        signUpPage = new SignUpPage(Hooks.driver);
        signUpPage.openSignUp();
    }

    @When("l'utilisateur sait ses informations valides")
    public void utilisateurSaistInformationsCorrectes() throws InterruptedException {
        signUpPage.entrerInformations("mimi",
                "sky",
                "LA Street",
                "LA",
                "STATE2",
                "123",
                "09876543",
                "134",
                "amaaaal",
                "password",
                "password");

    }

    @And("l'utilisateur clique sur le bouton register")
    public void utilisateurCliqueRegister() {
        signUpPage.clickOnRegister();
    }

    @Then("l'utilisateur accède page de succès")
    public void utilisateurAccedePageSucces() {
        Assertions.assertEquals("ParaBank | Customer Created", Hooks.driver.getTitle());
    }



    @When("l'utilisateur saisit ses infos personnelles et deux mots de passes differents")
    public void utilisateurSaisitNotMatchedPasswords() {
        signUpPage.entrerInformations("mimi",
                "sky",
                "LA Street",
                "LA",
                "STATE2",
                "123",
                "09876543",
                "134",
                "mimix",
                "password",
                "pass");

    }

    @Then("on affiche à l'utilisateur un message d'erreur")
    public void afficherMessageErreur(){
        String message = signUpPage.getMessageErreurPassword();
       Assertions.assertEquals("Passwords did not match.",message);

    }

    @When("l'utisateur ses infos mais sait un username qui existe déjà")
    public void utilisateurSaisitUsernameDejaExistant(){
        signUpPage.entrerInformations("mimi",
                "sky",
                "LA Street",
                "LA",
                "STATE2",
                "123",
                "09876543",
                "134",
                "nada",
                "pass",
                "pass");
    }

    @Then("on affiche un message d'erreur que username existe déjà")
    public void afficherUsernameExisteDeja() {
        String message = signUpPage.getMessageErreurUsername();
        Assertions.assertEquals("This username already exists.",message);
    }
}
