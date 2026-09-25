Feature: Ouvrir un nouveau compte
  Scenario: Ouvrir un nouveau compte valide
    Given l'utilisateur est connecté
    And l'utilisateur accède à la page pour ouvrir un nouveau compte
    When l'utilisateur sélectionne le type de compte SAVINGS de valeur "1"
    And l'utilisateur sélectionne le compte source "13677" pour déposer 100 dans le nouveau compte
    And l'utilisateur clique sur le bouton Open New Account
    Then on affiche une page qui indique l'opération a réussi