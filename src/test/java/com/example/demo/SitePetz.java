package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class SitePetz implements Buscador {
    private String enderecoSite;
    private String pesquisa;
    private String[] filtrosbyId;
    private WebDriver driver;
    {
        IniciarDriver iniciarDriver = new IniciarDriver();
        this.driver = iniciarDriver.getDriver();
    }

    public SitePetz(String enderecoSite, String pesquisa, String... filtrosById) {
        this.enderecoSite = enderecoSite;
        this.pesquisa = pesquisa;
        this.filtrosbyId = filtrosById;
        abrirSite();
        buscar();
    }

    @Override
    public void abrirSite() {
        this.driver.get(this.enderecoSite);
        this.driver.manage().window().maximize();

    }

    @Override
    public void buscar() {
        driver.findElement(By.linkText(pesquisa)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        for (String filtro : filtrosbyId) {
            driver.findElement(By.id(filtro)).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }

        List<WebElement> listaProdutos = driver.findElements(By.className("petzProduct"));
        listarProdutos(listaProdutos);

        detalheProduto(listaProdutos.get(0));
        driver.quit();
    }

    @Override
    public void listarProdutos(List<WebElement> listaProdutos) {
        System.out.println("\n---------------- Quantidade de produtos exibidos na página: " + listaProdutos.size() + " ----------------\n");
        listaProdutos.stream().forEach(s -> System.out.println("\n***** Produto *****\n " + s.getText() + "\n"));
    }

    @Override
    public void detalheProduto(WebElement produto) {
        produto.click();
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
        System.out.println(codigoProduto + "\n");
    }

}
