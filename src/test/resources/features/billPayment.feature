Feature: Payer ses factures
  Scenario: payer facture avec informations valides
    Given l'utilisateur est connecté
    And l'utilisateur accède à la page bill payment service
    When l'utilisateur saisit les informations valides
    And l'utilisateur clique sur le bouton Send Payment
    Then on affiche une page de paiement réussi


  Scenario: payer facture avec un montant invalide
    Given l'utilisateur est connecté
    And l'utilisateur accède à la page bill payment service
    When l'utilisateur saisit un montant invalide "DD"
    And l'utilisateur clique sur le bouton Send Payment
    Then on affiche un message d'erreur "Please enter a valid amount."


  Scenario: payer facture avec compte ID mismatch
    Given l'utilisateur est connecté
    And l'utilisateur accède à la page bill payment service
    When l'utilisateur saisit deux comptes ID differents
    And l'utilisateur clique sur le bouton Send Payment
    Then on affiche un message d'erreur ID mismatch "The account numbers do not match."

