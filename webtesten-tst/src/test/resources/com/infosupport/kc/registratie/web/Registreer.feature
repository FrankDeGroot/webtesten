Feature: Registreren
  I want to use this template for my feature file

  Scenario: Succesvolle registratie
    Given I have a browser open
    When I navigate to the home page
    And I enter the user name Frank
    And I enter the email frank@frank.frank
    And I submit the registration
    Then I should arrive at the activation page
