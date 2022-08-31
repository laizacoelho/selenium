package com.example.demo;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.AcceptedW3CCapabilityKeys;


public class TesteGoogle {

    private void pesquisarPor(final String stringPesquisa) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laiza\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        WebElement campoPesquisado = driver.findElement(By.name("q"));
        campoPesquisado.clear();
        campoPesquisado.sendKeys(stringPesquisa);

        System.out.println("Título da página: " + driver.getTitle());

        campoPesquisado.submit();

        (new WebDriverWait(driver, Duration.ofMillis(100))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver objDriver) {
                return objDriver.getTitle().toLowerCase().startsWith(stringPesquisa.toLowerCase());
            }
        });

        System.out.println("Título da página: " + driver.getTitle());

        driver.quit();
    }

    @Test
    public void test_pesquisarPor_LetsCode() {
        pesquisarPor("Lets Code!");
    }
}
