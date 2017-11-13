
package com.infosupport.kc.registratie.web;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

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

		registreerHappyFlow(naam);
		
		assertEquals("Activeer cursist", webDriver.getTitle());
	}

	@Test
	public void activeer() throws Exception {
		String naam = Long.toString(System.currentTimeMillis());

		registreerHappyFlow(naam);
		
		ActiveerPage activeerPage = new ActiveerPage(webDriver);
		
		activeerPage.setGebruikersnaam(naam);
		
		activeerPage.setActivatiecode("secret-" + naam);
		
		activeerPage.submit();
	}
	
	private void registreerHappyFlow(String naam) {

		webDriver.get("http://localhost:8080");
		
		RegistreerPage registreerPage = new RegistreerPage(webDriver);

		registreerPage.setGebruikersnaam(naam);

		registreerPage.setEmail(naam);

		registreerPage.submit();
		
		assertEquals("Activeer cursist", webDriver.getTitle());
	}
	
	@Test
	public void legeRegistratie() throws Exception {
		webDriver.get("http://localhost:8080");

		RegistreerPage registreerPage = new RegistreerPage(webDriver);
		
		registreerPage.submit();

		WebElement foutlabel = webDriver.findElement(By.className("label-important"));

		assertEquals("Ongeldige registratie", foutlabel.getText());
	}
}
