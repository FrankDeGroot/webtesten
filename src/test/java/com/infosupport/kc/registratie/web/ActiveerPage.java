package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActiveerPage {

	@FindBy(name = "activatieGebruikersnaam")
	private WebElement gebruikersnaam;

	@FindBy(name = "activatiecode")
	private WebElement inputActivatiecode;

	@FindBy(id = "activeer")
	private WebElement submit;

	@FindBy(className = "label-important")
	private WebElement foutlabel;

	private WebDriver webDriver;

	public ActiveerPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void setGebruikersnaam(String naam) {
		gebruikersnaam.sendKeys(naam);
	}

	public void setActivatiecode(String activatiecode) {
		inputActivatiecode.sendKeys(activatiecode);
	}

	public void submit() {
		submit.submit();
	}

	public String getFoutlabelText() {
		return foutlabel.getText();
	}

	public ExpectedCondition<Boolean> isFoutlabelText(String text) {
		return ExpectedConditions.textToBePresentInElement(foutlabel, text);
	}

}
