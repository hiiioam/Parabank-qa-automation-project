Feature: Transfert sur ParaBank
  Scenario: montant valide et compte source et compte destinataire valide
    Given l'utilisateur est connecté
    And l'utilisateur est sur la page Transfer Funds
    When l'utilisateur saisit le montant "100"
    And l'utilisateur sélectionne "13455" comme compte source
    And l'utilisateur sélectionne "13566" comme compte destination
    And l'utilisateur clique sur le bouton Transfer
    Then l'utilisateur voit message succès