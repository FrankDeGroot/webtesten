package com.infosupport.kc.registratie.web;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class ActivatieSteps {

    private WebDriver webDriver;
    private ActiveerPage activeerPage;

    public ActivatieSteps(SharedSteps sharedSteps) {
        this.webDriver = sharedSteps.getWebDriver();
        this.activeerPage = new ActiveerPage(webDriver);
    }

    @Given("^Ik ben op de activatiepagina$")
    public void ikBenOpDeActivatiePagina() {
        activeerPage.navigateTo();
    }
}
