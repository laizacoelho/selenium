package com.example.demo;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface Buscador {
    void abrirSite();
    void buscar();
    void listarProdutos(List<WebElement> listaProdutos);
    void detalheProduto(WebElement produto);

}
