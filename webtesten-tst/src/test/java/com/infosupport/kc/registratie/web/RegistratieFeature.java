package com.infosupport.kc.registratie.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class RegistratieFeature {

	public WebDriver webDriver;
	public RegistreerPage registreerPage;

	@Given("I have a browser open")
	public void iHaveABrowserOpen() {
		webDriver = new HtmlUnitDriver();
	}

	@When("I navigate to the home page")
	public void iNavigateToTheHomePage() {
		webDriver.get("http://localhost:8080/");
		registreerPage = new RegistreerPage(webDriver);
	}

	@And("I enter the user name (.*)")
	public void iEnterAUsername(String username) {
		registreerPage.setGebruikersnaam(username);
	}

	@And("I enter the email (.*)")
	public void iEnterTheEmai(String email) {
		registreerPage.setEmail(email);
	}

	@And("I submit the registration")
	public void iSubmitTheRegistration() {
		registreerPage.submit();
	}

	@Then("I should arrive at the activation page")
	public void iShouldArriveAtTheActivationPage() {
		assertThat(webDriver.getTitle(), is(equalTo("Activeer cursist")));
		webDriver.quit();
	}
}
