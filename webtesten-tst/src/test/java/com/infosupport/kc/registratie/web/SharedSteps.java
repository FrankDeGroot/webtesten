package com.infosupport.kc.registratie.web;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.picocontainer.Disposable;

import java.io.Closeable;
import java.io.IOException;

public class SharedSteps implements Disposable {

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public SharedSteps() {
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/delete");
    }

    @Override
    public void dispose() {
        webDriver.quit();
    }
}
