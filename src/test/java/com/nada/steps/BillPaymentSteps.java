package com.nada.steps;

import com.nada.pages.BillPaymentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class BillPaymentSteps {
    BillPaymentPage billPage;

    @And("l'utilisateur accède à la page bill payment service")
    public void userAccedeBillPage() {
        billPage = new BillPaymentPage(Hooks.driver);
        billPage.openBillPayment();
    }

    @When("l'utilisateur saisit les informations valides")
    public void userSaisitInfosValides() {
        billPage.saisirInfos("Nada",
                "LA Beach",
                "LA",
                "US",
                "124",
                "027823",
                "1446",
                "1446",
                "100",
                "13788");
    }

    @And("l'utilisateur clique sur le bouton Send Payment")
    public void clickOnSendPayment() {
        billPage.clickOnSendPayment();
    }

    @Then("on affiche une page de paiement réussi")
    public void afficherMsgSucces() {
        String msg = billPage.getMsgSucces();
        Assertions.assertEquals("Bill Payment Complete",msg);
    }


    @When("l'utilisateur saisit un montant invalide {string}")
    public void userSaisitMontantInvalide(String montant) {
        billPage.saisirInfos(
                "Nada",
                "LA Beach",
                "LA",
                "US",
                "124",
                "027823",
                "1446",
                "1446",
                montant,
                "13788"
        );
    }


    @Then("on affiche un message d'erreur {string}")
    public void afficherMessageMontantInvalide(String erreur) {
        String message = billPage.getErrorAmountInvalid();
        Assertions.assertEquals(erreur, message);
    }


    @When("l'utilisateur saisit deux comptes ID differents")
    public void userSaisitIDmismatch() {
        billPage.saisirInfos(
                "Nada",
                "LA Beach",
                "LA",
                "US",
                "124",
                "027823",
                "1446",
                "14",
                "100",
                "13788"
        );
    }


    @Then("on affiche un message d'erreur ID mismatch {string}")
    public void afficherMsgMismatch(String erreur) {
        String msg = billPage.getErrorAccountMismatch();
        Assertions.assertEquals(erreur,msg);
    }
}
