package br.com.funcionalidades.login;

import br.com.funcionalidades.driver.DriverNavegador;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;

public class LoginSteps {

    LoginPage loginPage;
    String username;
    String password;
    String produtos = "Products";


    @Dado("que esteja na pagina inicial")
    public void que_esteja_na_pagina_inicial() {
        DriverNavegador.getDriver();
        DriverNavegador.acessarSite("https://www.saucedemo.com/");

    }

    @Quando("informar login valido")
    public void informar_login_valido() throws IOException {
        loginPage = new LoginPage();
        loginPage.clickSetInpUsername();
        loginPage.setInpUsername(username);
        loginPage.setInpPassword(password);
        loginPage.clickBtnLogin();
    }

    @Entao("deve apresentar a tela inicial do sistema")
    public void deve_apresentar_a_tela_inicial_do_sistema() {
        Assert.assertEquals(produtos, loginPage.getUsuarioLogado());

    }
}
