Feature: Connexion à ParaBank
  Scenario: Connexion avec des identifiants valides
    Given l'utilisateur est sur la page de connexion
    When il saisit un nom d'utilisateur et un mot de passe valides
    And il clique sur login
    Then il doit accéder à la page Accounts overview

  Scenario Outline: Connexion avec des identifiants invalides
    Given l'utilisateur est sur la page de connexion
    When il saisit "<username>" et "<password>"
    And il clique sur login
    Then il doit voir la page erreur

    Examples:
      | username | password |
      | nada     | wrong    |
      | wrong  | password |
      | wrong    | wrong    |