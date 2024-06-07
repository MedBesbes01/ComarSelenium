@search
Feature: Actualités sur le site de COMAR Assurances

  Scenario: Recherche d un partenaire sur la page Actualités
    Given L utilisateur accède au site web de COMAR
    When L utilisateur clique sur la rubrique "Actualités" en haut de la page
    And le texte "Actualités" doit être présent sur la page
    And L utilisateur entre le mot "COMAR Assurances partenaire" dans le formulaire de recherche
    And L utilisateur clique sur le bouton RECHERCHE
    Then Le texte "COMAR Assurances partenaire du Semi-Marathon Ulysse Djerba" doit apparaître
