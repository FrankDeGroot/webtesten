
package com.infosupport.kc.registratie.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistratieSpaTest {

	private WebDriver webDriver;
	private WebDriverWait waiter;

	@Before
	public void before() {
		webDriver = new HtmlUnitDriver(true);
		waiter = new WebDriverWait(webDriver, 5, 100);
	}

	@After
	public void after() {
		webDriver.quit();
	}

	@Test
	public void registreer() throws Exception {
		String naam = Long.toString(System.currentTimeMillis());

		registreerHappyFlow(naam);

		// assertEquals("Activeer cursist", webDriver.getTitle());
	}

	@Test
	public void activeer() throws Exception {
		String naam = Long.toString(System.currentTimeMillis());

		registreerHappyFlow(naam);

		ActiveerPage activeerPage = new ActiveerPage(webDriver);

		activeerPage.setGebruikersnaam(naam);

		activeerPage.setActivatiecode("secret-" + naam);

		activeerPage.submit();

		waiter.until(webDriver -> "Account page".equals(webDriver.getTitle()));

		// assertEquals("Account page", webDriver.getTitle());
	}

	private void registreerHappyFlow(String naam) {

		webDriver.get("http://localhost:8080/registreer.html");

		RegistreerPage registreerPage = new RegistreerPage(webDriver);

		registreerPage.setGebruikersnaam(naam);

		registreerPage.setEmail(naam);

		registreerPage.submit();

//		waiter.until(ExpectedConditions.titleIs("Activeer cursist"));
		
		waiter.until(webDriver -> {
			JavascriptExecutor executor = (JavascriptExecutor) webDriver;
			return "#activeer".equals(executor.executeScript("return window.location.hash;"));
		});
	}

	@Test
	public void legeRegistratie() throws Exception {
		webDriver.get("http://localhost:8080/registreer.html");

		RegistreerPage registreerPage = new RegistreerPage(webDriver);

		registreerPage.submit();

		waiter.until(webDriver -> "Ongeldige registratie".equals(registreerPage.getFoutlabelText()));

		// assertEquals("Ongeldige registratie", registreerPage.getFoutlabelText());
	}
}
