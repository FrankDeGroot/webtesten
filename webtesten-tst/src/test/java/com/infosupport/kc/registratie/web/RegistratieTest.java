package com.infosupport.kc.registratie.web;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    }

    @After
    public void after() {
        webDriver.quit();
    }

    @Test
    public void SuccessfulRegistration() {
    }

}
