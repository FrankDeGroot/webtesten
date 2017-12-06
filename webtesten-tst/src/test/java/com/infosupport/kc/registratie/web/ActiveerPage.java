package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiveerPage {
    private WebDriver webDriver;

    @FindBy(name = "activatieGebruikersnaam")
    private WebElement gebruikersnaamElement;

    @FindBy(name = "activatiecode")
    private WebElement activatiecodeElement;

    @FindBy(id = "activeer")
    private WebElement submit;

    public ActiveerPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {
        webDriver.get("http://localhost:8080/activeer");
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        gebruikersnaamElement.sendKeys(gebruikersnaam);
    }

    public void setActivatiecode(String activatiecode) {
        activatiecodeElement.sendKeys(activatiecode);
    }

    public void submit() {
        submit.click();
    }
}
