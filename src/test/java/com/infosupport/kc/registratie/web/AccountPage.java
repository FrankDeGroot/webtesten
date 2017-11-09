package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	@FindBy(css = "h1")
	private WebElement header;
	
	public AccountPage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
	
	public String getHeader() {
		return header.getText();
	}
}
