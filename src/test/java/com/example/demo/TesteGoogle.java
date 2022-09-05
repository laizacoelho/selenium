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
        driver.get("https://www.petz.com.br");
        driver.manage().window().maximize();

        driver.findElement(By.linkText(stringPesquisa)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        driver.findElement(By.id("label_-4_1684")).click();
       // Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        driver.findElement(By.id("label_-4_1685")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        driver.findElement(By.id("label_-2_1149")).click();
        Thread.sleep(3000);

        List<WebElement> listaProdutos = driver.findElements(By.className("petzProduct"));
        System.out.println("\n---------------- Quantidade de produtos exibidos na página: " + listaProdutos.size() + " ----------------\n");
        listaProdutos.stream().forEach(s -> System.out.println("\n***** Produto *****\n " + s.getText() + "\n"));
        Thread.sleep(3000);

        System.out.println("Título da página: " + driver.getTitle());

        listaProdutos.get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        String nomeProduto = driver.findElement(By.className("product-title")).getText();
        String codigoProduto = driver.findElement(By.id("product-code")).getText();
        String statusProduto = driver.findElement(By.id("available-product")).getText();
        String marcaProduto = driver.findElement(By.className("blue")).getText();
        String precoProduto = driver.findElement(By.className("current-price-left")).getText();
        String descricaoProduto = driver.findElement(By.className("description")).getText();


        System.out.println("\n---------------- Produto Selecionado: " + nomeProduto + " ----------------");
        System.out.println("Status: " + statusProduto);
        System.out.println("Marca: " + marcaProduto);
        System.out.println("Preço: " + precoProduto);
        System.out.println(descricaoProduto);
        System.out.println(codigoProduto);

        // driver.quit();
    }

    @Test
    public void test_pesquisarPor_LetsCode() throws InterruptedException {
        pesquisarPor("Gatos");
    }
}
