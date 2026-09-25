Feature: Inscription à ParaBank
  //Scenario: Inscription avec des informations valides
    //Given l'utilisateur est sur la page d'inscription
    //When l'utilisateur sait ses informations valides
    //And l'utilisateur clique sur le bouton register
    //Then l'utilisateur accède page de succès



  Scenario: Mot de passe et mot de passe confirmé sont différents
    Given l'utilisateur est sur la page d'inscription
    When l'utilisateur saisit ses infos personnelles et deux mots de passes differents
    And l'utilisateur clique sur le bouton register
    Then on affiche à l'utilisateur un message d'erreur


  Scenario: Username existe déjà
    Given l'utilisateur est sur la page d'inscription
    When l'utisateur ses infos mais sait un username qui existe déjà
    And l'utilisateur clique sur le bouton register
    Then on affiche un message d'erreur que username existe déjà
