package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivatiePage {
	
	@FindBy(name="activatieGebruikersnaam")
	private WebElement activatieGebruikersnaam;
	
	@FindBy(name="activatiecode")
	private WebElement activatiecode;
	
	@FindBy(id = "activeer")
	private WebElement submit;
	
	@FindBy(className = "label-important")
	private WebElement foutlabel;
	
	public ActivatiePage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
	
	public ActivatiePage setGebruikersnaam(String gebruikersnaam) {
		activatieGebruikersnaam.sendKeys(gebruikersnaam);
		return this;
	}
	
	public ActivatiePage setActivatiecode(String email) {
		activatiecode.sendKeys(email);
		return this;
	}
	
	public ActivatiePage submit() {
		submit.submit();
		return this;
	}
	
	public String getFoutmelding() {
		return foutlabel.getText();
	}

}
