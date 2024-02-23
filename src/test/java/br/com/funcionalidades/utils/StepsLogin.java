package br.com.funcionalidades.utils;

import br.com.funcionalidades.driver.DriverNavegador;
import br.com.funcionalidades.login.LoginPage;
import org.junit.Assert;

import java.io.IOException;

public class StepsLogin {

    DriverNavegador driverNavegador;
    LoginPage loginPage;
    String username;
    String password;
    String produtos = "Products";

    public void paginaInicial() {
        driverNavegador = new DriverNavegador();
        driverNavegador.acessarSite("https://www.saucedemo.com/");

    }

    public void digitarLogin() throws IOException {
        loginPage = new LoginPage();
        loginPage.clickSetInpUsername();
        loginPage.setInpUsername(username);
        loginPage.setInpPassword(password);
        loginPage.clickBtnLogin();
    }

    public void validarAcesso() {
        Assert.assertEquals(produtos, loginPage.getUsuarioLogado());

    }
}

