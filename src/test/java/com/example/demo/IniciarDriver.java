package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IniciarDriver {
    private WebDriver driver;

    public static WebDriver inicializacaoDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--log-level=3");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--incognito");
        return new ChromeDriver(chromeOptions);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
