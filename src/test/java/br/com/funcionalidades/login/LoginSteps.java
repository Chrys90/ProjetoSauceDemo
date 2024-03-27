package br.com.funcionalidades.login;

import br.com.funcionalidades.driver.DriverNavegador;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.io.IOException;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Before
    public void iniciarNavegador(Scenario cenario){
        DriverNavegador.getDriver();
        DriverNavegador.setNomeCenario(cenario.getName());
        DriverNavegador.criaDiretorio();
    }

    @After
    public void depoisCenario(Scenario scenario) throws IOException {
        DriverNavegador.cenarioErroScreenShot(scenario);
    }

    @Dado("que esteja na pagina inicial")
    public void que_esteja_na_pagina_inicial() throws IOException {
        DriverNavegador.acessarAplicao("https://www.saucedemo.com/");
        DriverNavegador.printScreen("pagina inicial");
    }

    @Quando("informar os dados de login sem informar o usuario")
    public void informarOsDadosDeLoginSemInformarOUsuario() throws IOException {
        loginPage.setInpPassword();
        loginPage.clickBtnLogin();
    }

    @Entao("deve exibir mensagem de erro informando que o username e obrigatorio")
    public void deveExibirMensagemDeErroInformandoQueOUsernameEObrigatorio() throws IOException {
        loginPage.validarErroUsername();

        DriverNavegador.printScreen("erro username");
    }

    @Quando("informar os dados de login sem informar a senha")
    public void informarOsDadosDeLoginSemInformarASenha() throws IOException {
        loginPage.clickSetInpUsername();
        loginPage.setInpUsername();
        loginPage.clickBtnLogin();
    }

    @Entao("deve exibir mensagem de erro informando que o password e obrigatorio")
    public void deveExibirMensagemDeErroInformandoQueOPasswordEObrigatorio() throws IOException {
        loginPage.validarErroPassword();

        DriverNavegador.printScreen("erro password");
    }

    @Quando("informar os dados de login de um usuario bloqueado")
    public void informarOsDadosDeLoginDeUmUsuarioBloqueado() throws IOException {
        loginPage.clickSetInpUsername();
        loginPage.setInmpUsernameBlock();
        loginPage.setInpPassword();
        loginPage.clickBtnLogin();
    }

    @Entao("deve exibir mensagem de erro informando que o usuario esta bloqueado")
    public void deveExibirMensagemDeErroInformandoQueOUsuarioEstaBloqueado() throws IOException {
        loginPage.validarErroUsuarioBlock();

        DriverNavegador.printScreen("erro login bloqueado");
    }

    @Quando("informar os dados de login")
    public void informarOsDadosDeLogin() throws IOException {
        loginPage.clickSetInpUsername();
        loginPage.setInpUsername();
        loginPage.setPasswordIncorreto();
        loginPage.clickBtnLogin();
    }

    @Entao("deve exibir mensagem de erro informando que o usuario e senha estão incorretos")
    public void deveExibirMensagemDeErroInformandoQueOUsuarioESenhaEstãoIncorretos() throws IOException {
        loginPage.validarLoginIncorreto();

        DriverNavegador.printScreen("erro de login incorreto");
    }

    @Quando("informar login valido")
    public void informar_login_valido() throws IOException {
        loginPage.clickSetInpUsername();
        loginPage.setInpUsername();
        loginPage.setInpPassword();
        loginPage.clickBtnLogin();
    }

    @Entao("deve apresentar a tela inicial do sistema")
    public void deve_apresentar_a_tela_inicial_do_sistema() throws IOException {
        loginPage.validarLoginSucesso();

        DriverNavegador.printScreen("tela inicial do sistema");
    }

}
