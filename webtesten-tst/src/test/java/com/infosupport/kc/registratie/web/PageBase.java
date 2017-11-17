package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class PageBase {

	protected WebDriver webDriver;

	@FindBy(className = "label-important")
	protected WebElement foutlabel;

	protected PageBase(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public String getFoutlabelText() {
		return foutlabel.getText();
	}

	public ExpectedCondition<Boolean> isFoutlabelText(String text) {
		return ExpectedConditions.textToBePresentInElement(foutlabel, text);
	}

}
