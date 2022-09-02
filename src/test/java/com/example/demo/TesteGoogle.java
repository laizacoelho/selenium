package com.example.demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.AcceptedW3CCapabilityKeys;

import javax.swing.*;


public class TesteGoogle {

    private void pesquisarPor(final String stringPesquisa) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laiza\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--log-level=3");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.com.br");

        //locate a web element
        String tagName = driver.findElement(By.id("searchDropdownBox")).getText();
        System.out.println(tagName);

        WebElement categoria = driver.findElement(By.id("searchDropdownBox"));
        Actions actions = new Actions(driver);
        actions.moveToElement(categoria).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
        dropdown.selectByIndex(8);
        actions.click();
        categoria.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        driver.findElement(By.linkText("Adulto")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        driver.findElement(By.linkText("LEGO")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        driver.findElement(By.linkText("Amazon.com.br")).click();
        Thread.sleep(3000);


        driver.findElements(By.className("sg-col-4-of-12")).stream().forEach(s -> System.out.println(s.getText()));
        //   driver.findElements(By.className("sg-col-4-of-12")).stream().forEach(s -> System.out.println("******************************* " + s.get("a-offscreen")));
        ////span[@class="a-offscreen"]
        List < WebElement > pesquisa = driver.findElements(By.className("sg-col-4-of-12"));
        System.out.println("\n---------------- Quantidade de itens na pagina: " + pesquisa.size() + " ------------------------- \n");




      /*  WebElement campoPesquisado = driver.findElement(By.name("q"));
        campoPesquisado.clear();
        campoPesquisado.sendKeys(stringPesquisa);

        System.out.println("Título da página: " + driver.getTitle());

        campoPesquisado.submit(); */

        (new WebDriverWait(driver, Duration.ofMillis(1000))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver objDriver) {
                return objDriver.getTitle().toLowerCase().startsWith(stringPesquisa.toLowerCase());
            }
        });

        System.out.println("Título da página: " + driver.getTitle());

        driver.quit();
    }

    @Test
    public void test_pesquisarPor_LetsCode() throws InterruptedException {
        pesquisarPor("Lets Code!");
    }
}
