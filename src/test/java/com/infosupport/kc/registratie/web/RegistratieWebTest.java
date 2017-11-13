package com.infosupport.kc.registratie.web;

import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.matchers.JUnitMatchers.containsString;

public class RegistratieWebTest {

	private WebDriver webDriver;
	
	@BeforeClass
	public static void setupClass() {
//		ChromeDriverManager.getInstance().setup();
		InternetExplorerDriverManager.getInstance().setup();
//		EdgeDriverManager.getInstance().setup();
	}

	@Before
	public void setUp() {
//		webDriver = new ChromeDriver();
		DesiredCapabilities IEcaps = DesiredCapabilities.internetExplorer();
		IEcaps .setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		webDriver = new InternetExplorerDriver();
//		webDriver = new EdgeDriver();
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
