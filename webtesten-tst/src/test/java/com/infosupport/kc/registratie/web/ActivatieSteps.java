package com.infosupport.kc.registratie.web;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class ActivatieSteps {

    private WebDriver webDriver;
    private ActivatiePage activatiePage;

    public ActivatieSteps(SharedSteps sharedSteps) {
        this.webDriver = sharedSteps.getWebDriver();
        this.activatiePage = new ActivatiePage(webDriver);
    }

    @Given("^Ik ben op de activatiepagina$")
    public void ikBenOpDeActivatiePagina() {
        activatiePage.navigateTo();
    }
}
