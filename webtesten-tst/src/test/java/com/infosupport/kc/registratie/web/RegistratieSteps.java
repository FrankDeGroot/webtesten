package com.infosupport.kc.registratie.web;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistratieSteps {

    private WebDriver webDriver;
    private RegistratiePage registratiePage;

    public RegistratieSteps(SharedSteps sharedSteps) {
        this.webDriver = sharedSteps.getWebDriver();
        registratiePage = new RegistratiePage(webDriver);
    }

    @Given("^Ik ben op de registratiepagina$")
    public void ikBenOpDeRegistratiepagina() throws Throwable {
        registratiePage.navigateTo();
    }

    @When("^Ik voer mijn naam in$")
    public void ikVoerMijnNaamIn() throws Throwable {
        registratiePage.setGebruikersnaam("Test");
    }

    @And("^Ik voer mijn e-mailadres in$")
    public void ikVoerMijnEMailadresIn() throws Throwable {
        registratiePage.setEmail("Test");
    }

    @And("^Ik druk op Submit$")
    public void ikDrukOpSubmit() throws Throwable {
        registratiePage.submit();
    }

    @Then("^Ik zou op de activatiepagina moeten zijn$")
    public void ikZouOpDeActivatiepaginaMoetenZijn() throws Throwable {
        assertThat(webDriver.getTitle(), equalTo("Activeer cursist"));
    }

    @Given("^Ik ben geregistreerd$")
    public void ikBenGeregistreerd() throws Throwable {
        ikBenOpDeRegistratiepagina();
        ikVoerMijnNaamIn();
        ikVoerMijnEMailadresIn();
        ikDrukOpSubmit();
    }
}
