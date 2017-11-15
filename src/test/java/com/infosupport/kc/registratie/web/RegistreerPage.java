package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistreerPage extends PageBase {

	@FindBy(name = "registratieGebruikersnaam")
	private WebElement gebruikersnaam;

	@FindBy(name = "registratieEmail")
	private WebElement inputEmail;

	@FindBy(id = "registreer")
	private WebElement submit;

	public RegistreerPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void setGebruikersnaam(String naam) {
		gebruikersnaam.sendKeys(naam);
	}

	public void setEmail(String email) {
		inputEmail.sendKeys(email);
	}

	public void submit() {
		submit.submit();
	}
}
