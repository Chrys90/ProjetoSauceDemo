package br.com.funcionalidades.login;

import br.com.funcionalidades.driver.DriverNavegador;
import br.com.funcionalidades.utils.StepsLogin;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;


import java.io.IOException;

public class LoginSteps {


    String produtos = "Products";
    StepsLogin stepsLogin;


    @After
    public void fechaNavegador() {
        DriverNavegador.fecharNavegador();
    }


    @Dado("que esteja na pagina inicial")
    public void que_esteja_na_pagina_inicial() {
        stepsLogin = new StepsLogin();
        stepsLogin.paginaInicial();

    }

    @Quando("informar login valido")
    public void informar_login_valido() throws IOException {
        stepsLogin.digitarLogin();
    }

    @Entao("deve apresentar a tela inicial do sistema")
    public void deve_apresentar_a_tela_inicial_do_sistema() {
        stepsLogin.validarAcesso();

    }
}
