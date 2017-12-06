package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistratiePage {
    private WebDriver webDriver;

    @FindBy(name = "registratieGebruikersnaam")
    private WebElement gebruikersnaamElement;

    @FindBy(name = "registratieEmail")
    private WebElement emailElement;

    @FindBy(id = "registreer")
    private WebElement submit;

    @FindBy(className = "label-important")
    private WebElement errorLabel;

    public RegistratiePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {
        webDriver.get("http://localhost:8080/registreer");
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        gebruikersnaamElement.sendKeys(gebruikersnaam);
    }

    public void setEmail(String email) {
        emailElement.sendKeys(email);
    }

    public void submit() {
        submit.click();
    }

    public String getError() {
        return errorLabel.getText();
    }
}
