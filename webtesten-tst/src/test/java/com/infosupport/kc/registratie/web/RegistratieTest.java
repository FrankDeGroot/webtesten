package com.infosupport.kc.registratie.web;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@Ignore
public class RegistratieTest {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @BeforeClass
    public static void beforeClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void before() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Me\\Downloads\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 5);
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

//        webDriverWait.until(ExpectedConditions.titleIs("Activeer cursist"));

        assertThat(webDriver.getTitle(), equalTo("Activeer cursist"));

        ActivatiePage activatiePage = new ActivatiePage(webDriver);

        activatiePage.navigateTo();

        activatiePage.setGebruikersnaam(naam);

        activatiePage.setActivatiecode("secret-" + naam);

        activatiePage.submit();

//        webDriverWait.until(ExpectedConditions.titleIs("Account page"));

        assertThat(webDriver.getTitle(), equalTo("Account page"));
    }

    @Test
    public void emptyRegistrationShouldFail() throws Exception {
        RegistratiePage registratiePage = new RegistratiePage(webDriver);

        registratiePage.navigateTo();

        registratiePage.submit();

        assertThat(registratiePage.getError(), equalTo("Ongeldige registratie"));
    }

}
