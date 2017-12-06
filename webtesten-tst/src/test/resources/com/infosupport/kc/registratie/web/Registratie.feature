Feature: Registreren

  Scenario: Succesvolle registratie
    Given Ik ben op de registratiepagina
    When Ik voer mijn naam in
    And Ik voer mijn e-mailadres in
    And Ik druk op Submit
    Then Ik zou op de activatiepagina moeten zijn