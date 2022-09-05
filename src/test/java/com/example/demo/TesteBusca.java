package com.example.demo;

import org.junit.jupiter.api.Test;

public class TesteBusca {

    private void pesquisarPor(final String stringPesquisa) {

        SitePetz sitePetz = new SitePetz("https://www.petz.com.br", stringPesquisa, "label_-4_1684", "label_-4_1685", "label_-2_1149");
    }

    @Test
    public void test_pesquisarPor_LetsCode() {
        pesquisarPor("Gatos");
    }
}
