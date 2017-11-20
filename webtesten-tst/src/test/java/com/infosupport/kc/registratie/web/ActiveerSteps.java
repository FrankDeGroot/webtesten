package com.infosupport.kc.registratie.web;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ActiveerSteps extends StepsBase {

	public ActiveerPage activeerPage;

	@Given("^I navigate to the activeer page$")
	public void iNavigateToTheActiveerPage() {
		webDriver.get("http://localhost:8080/activeer");
		activeerPage = new ActiveerPage(webDriver);
	}

	@Then("^I enter the activation user name (.*)$")
	public void iEnterTheActivationUsername(String username) {
		activeerPage.setGebruikersnaam(username);
	}

	@Then("^I enter the activation code (.*)$")
	public void iEnterTheActivationCode(String activationCode) {
		activeerPage.setActivatiecode(activationCode);
	}

	@Then("^I submit the activation$")
	public void iSubmitTheActivation() {
		activeerPage.submit();
	}

}
