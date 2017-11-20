package com.infosupport.kc.registratie.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistreerSteps {

	public WebDriver webDriver;
	public RegistreerPage registreerPage;

	@Given("^I have a browser open$")
	public void iHaveABrowserOpen() {
		webDriver = new HtmlUnitDriver();
		webDriver.get("http://localhost:8080/delete");
	}

	@When("^I navigate to the home page$")
	public void iNavigateToTheHomePage() {
		webDriver.get("http://localhost:8080/");
		registreerPage = new RegistreerPage(webDriver);
	}

	@And("^I enter the user name (.*)$")
	public void iEnterAUsername(String username) {
		registreerPage.setGebruikersnaam(username);
	}

	@And("^I enter the email (.*)$")
	public void iEnterTheEmai(String email) {
		registreerPage.setEmail(email);
	}

	@And("^I submit the registration$")
	public void iSubmitTheRegistration() {
		registreerPage.submit();
	}

	@Then("^I should arrive at the activation page$")
	public void iShouldArriveAtTheActivationPage() {
		assertThat(webDriver.getTitle(), is(equalTo("Activeer cursist")));
	}
	
	@After
	public void after() {
		webDriver.quit();
	}
}
