Feature: Activeren
	Activeren van geregistreerde gebruikers.
	
	Background:
		Given A registered user Test
		Given I navigate to the activeer page
	
  Scenario: Succesvolle activatie
    When I enter the activation user name Test
    And I enter the activation code secret-Test
    And I submit the activation
    Then I should arrive at the page titled Account page
	