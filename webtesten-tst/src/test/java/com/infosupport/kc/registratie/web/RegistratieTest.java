package com.infosupport.kc.registratie.web;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class RegistratieTest {

    private WebDriver webDriver;

    @BeforeClass
    public static void beforeClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void before() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Me\\Downloads\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/delete");
    }

    @After
    public void after() {
        webDriver.quit();
    }

    @Test
    public void SuccessfulRegistration() throws Exception {
        RegistratiePage registratiePage = new RegistratiePage(webDriver);

        String naam = "Test";

        registratiePage.navigateTo();

        registratiePage.setGebruikersnaam(naam);

        registratiePage.setEmail(naam);

        registratiePage.submit();

        assertThat(webDriver.getTitle(), equalTo("Activeer cursist"));

        webDriver.get("http://localhost:8080/activeer");

        WebElement activatieGebruikersnaam = webDriver.findElement(By.name("activatieGebruikersnaam"));
        activatieGebruikersnaam.sendKeys(naam);

        WebElement activatiecode = webDriver.findElement(By.name("activatiecode"));
        activatiecode.sendKeys("secret-" + naam);

        WebElement activeerSubmit = webDriver.findElement(By.id("activeer"));
        activeerSubmit.click();

        assertThat(webDriver.getTitle(), equalTo("Account page"));
    }

    @Test
    public void emptyRegistrationShouldFail() throws Exception {
        webDriver.get("http://localhost:8080/");

        WebElement registreerSubmit = webDriver.findElement(By.id("registreer"));
        registreerSubmit.click();

        WebElement errorLabel = webDriver.findElement(By.className("label-important"));
        assertThat(errorLabel.getText(), equalTo("Ongeldige registratie"));
    }

}
