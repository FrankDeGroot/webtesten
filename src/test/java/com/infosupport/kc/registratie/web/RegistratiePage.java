package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistratiePage {
	
	@FindBy(name="registratieGebruikersnaam")
	private WebElement registratieGebruikersnaam;
	
	@FindBy(name="registratieEmail")
	private WebElement registratieEmail;
	
	@FindBy(id = "registreer")
	private WebElement submit;
	
	@FindBy(className = "label-important")
	private WebElement foutlabel;
	
	public RegistratiePage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
	
	public RegistratiePage setGebruikersnaam(String gebruikersnaam) {
		registratieGebruikersnaam.sendKeys(gebruikersnaam);
		return this;
	}
	
	public RegistratiePage setEmail(String email) {
		registratieEmail.sendKeys(email);
		return this;
	}
	
	public RegistratiePage submit() {
		submit.submit();
		return this;
	}
	
	public String getFoutmelding() {
		return foutlabel.getText();
	}

}
