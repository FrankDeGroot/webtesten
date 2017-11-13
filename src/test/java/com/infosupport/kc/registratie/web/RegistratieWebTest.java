package com.infosupport.kc.registratie.web;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class RegistratieWebTest {

	private WebDriver webDriver;

	@Before
	public void before() {
		webDriver = new HtmlUnitDriver();
	}

	@After
	public void after() {
		webDriver.close();
	}

	@Test
	public void registreer() throws Exception {
		String naam = Long.toString(System.currentTimeMillis());

		webDriver.get("http://localhost:8080");

		WebElement gebruikersnaam =
				webDriver.findElement(By.name("registratieGebruikersnaam"));
		gebruikersnaam.sendKeys(naam);
		
		WebElement email = 
				webDriver.findElement(By.name("registratieEmail"));
		email.sendKeys(naam);
		
		WebElement submit =
				webDriver.findElement(By.id("registreer"));
		submit.submit();
		
		assertEquals("Activeer cursist", webDriver.getTitle());
	}
}
