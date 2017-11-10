package com.infosupport.kc.registratie.web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class AccountPage {

	@FindBy(css = "h1")
	private WebElement header;
		
	private WebDriverWait waiter;
	
	public AccountPage(WebDriver webDriver) {
		this.waiter = new WebDriverWait(webDriver, 5);
		PageFactory.initElements(webDriver, this);
	}

	public AccountPage waitUntilDisplayed() {
		waiter.until(new Predicate<WebDriver>() {

			@Override
			public boolean apply(WebDriver webDriver) {
				JavascriptExecutor executor = (JavascriptExecutor)webDriver;
				return "#account".equals(executor.executeScript("return window.location.hash;"));
			}
			
		});
		return this;
	}
	
	public String getHeader() {
		return header.getText();
	}
}
