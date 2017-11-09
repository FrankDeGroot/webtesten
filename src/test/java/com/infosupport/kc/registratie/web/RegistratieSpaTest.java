package com.infosupport.kc.registratie.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class RegistratieSpaTest {
	
	private WebDriver webDriver;
	
	@Before
	public void setUp() {
		webDriver = new HtmlUnitDriver(true);
	}
	
	@After
	public void tearDown() {
		webDriver.quit();
	}
	
	@Test
	public void shouldRegister() throws Exception {
		String naam = Long.toString(System.currentTimeMillis());

		webDriver.get("http://localhost:8080/registreer.html");
		
		TimeUnit.MILLISECONDS.sleep(100);

		new RegistratiePage(webDriver).setGebruikersnaam(naam).setEmail(naam).submit();
		
		TimeUnit.MILLISECONDS.sleep(100);

		new ActivatiePage(webDriver).setGebruikersnaam(naam).setActivatiecode("secret-" + naam).submit();
		
		TimeUnit.MILLISECONDS.sleep(100);

		assertThat(new AccountPage(webDriver).getHeader(), is(containsString(naam)));
	}

}
