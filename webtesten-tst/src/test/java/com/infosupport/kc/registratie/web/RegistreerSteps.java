package com.infosupport.kc.registratie.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistreerSteps extends StepsBase {

	public RegistreerPage registreerPage;

	@Before
	public void before() {
		webDriver = WebDriverFactory.create();
	}

	@After
	public void after() {
		webDriver.quit();
	}

	@Given("^There are no registered users$")
	public void thereAreNoRegisteredUsers() {
		webDriver.get("http://localhost:8080/delete");
	}

	@When("^I navigate to the home page$")
	public void iNavigateToTheHomePage() {
		webDriver.get("http://localhost:8080/");
		registreerPage = new RegistreerPage(webDriver);
	}

	@Then("^I enter the registration user name (.*)$")
	public void iEnterTheRegistrationUsername(String username) {
		registreerPage.setGebruikersnaam(username);
	}

	@Then("^I enter the email (.*)$")
	public void iEnterTheEmail(String email) {
		registreerPage.setEmail(email);
	}

	@Then("^I submit the registration$")
	public void iSubmitTheRegistration() {
		registreerPage.submit();
	}

	@Then("^I should arrive at the page titled (.*)$")
	public void iShouldArriveAtTheActivationPage(String pageTitle) {
		assertThat(webDriver.getTitle(), is(equalTo(pageTitle)));
	}

	@Then("^I should see the error (.*)$")
	public void iShouldSeeTheError(String errorMessage) {
		assertEquals(errorMessage, registreerPage.getFoutlabelText());
	}

	@Given("^A registered user (.*)$")
	public void aRegisteredUser(String username) {
		iNavigateToTheHomePage();
		iEnterTheRegistrationUsername(username);
		iEnterTheEmail(username);
		iSubmitTheRegistration();
	}
}
