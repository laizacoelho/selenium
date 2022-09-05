package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IniciarDriver {
    private WebDriver driver;

    public IniciarDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laiza\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--log-level=3");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--incognito");
        this.driver = new ChromeDriver(chromeOptions);

    }

    public WebDriver getDriver() {
        return driver;
    }
}
