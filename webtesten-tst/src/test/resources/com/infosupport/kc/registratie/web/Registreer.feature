Feature: Registreren
  Registreren van nieuwe cursisten.
  
  Background:
  	Given There are no registered users
    When I navigate to the home page

	@HappyFlow
  Scenario: Succesvolle registratie
    When I enter the registration user name Test
    And I enter the email test@test.test
    And I submit the registration
    Then I should arrive at the page titled Activeer cursist
    
  @UnhappyFlow
  Scenario: Lege registratie
    When I submit the registration
    Then I should arrive at the page titled Registreer cursist
    And I should see the error Ongeldige registratie
    
  Scenario Outline: Ongeldige registratie
    When I enter the registration user name <username>
    And I enter the email <email>
    And I submit the registration
    Then I should arrive at the page titled Registreer cursist
    And I should see the error Ongeldige registratie
    
  Examples:
  	| username | email |
  	|          | test  |
  	| test     |       |
  	|          |       |
  
  