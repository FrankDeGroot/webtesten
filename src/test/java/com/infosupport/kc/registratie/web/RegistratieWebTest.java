package com.infosupport.kc.registratie.web;

import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.matchers.JUnitMatchers.containsString;

public class RegistratieWebTest {

	private WebDriver webDriver;

	@Before
	public void setUp() {
		webDriver = new HtmlUnitDriver();
	}

	@After
	public void tearDown() {
		webDriver.quit();
	}

	@Test
	public void shouldRegister() throws Exception {
		String naam = Long.toString(System.currentTimeMillis());

		webDriver.get("http://localhost:8080/");

		new RegistratiePage(webDriver).setGebruikersnaam(naam).setEmail(naam).submit();
		new ActivatiePage(webDriver).setGebruikersnaam(naam).setActivatiecode("secret-" + naam).submit();

		assertThat(new AccountPage(webDriver).getHeader(), is(containsString(naam)));
	}

	@Test
	public void shouldNotRegisterEmptyUsername() throws Exception {

		webDriver.get("http://localhost:8080/");

		RegistratiePage registratiePage = new RegistratiePage(webDriver);
		registratiePage.submit();
		assertThat(registratiePage.getFoutmelding(), is(equalTo("Ongeldige registratie")));
	}
}
