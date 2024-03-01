package br.com.funcionalidades.login;

import br.com.funcionalidades.driver.DriverNavegador;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    String username;
    String password;
    String produtos = "Products";
    String erroUsername = "Epic sadface: Username is required";
    String erroPassword = "Epic sadface: Password is required";
    String usernameBlock;
    String txtUsernameBlock = "Epic sadface: Sorry, this user has been locked out.";
    String erroLogin = "Epic sadface: Username and password do not match any user in this service";


    @Before
    public void iniciaNavegador(Scenario cenario){
        DriverNavegador.getDriver();
        DriverNavegador.setNomeCenario(cenario.getName());
        DriverNavegador.criaDiretorio();
    }

    @After
    public void cenario(Scenario scenario) throws IOException {
        DriverNavegador.cenarioErroScreenShot(scenario);
    }

    @Dado("que esteja na pagina inicial")
    public void que_esteja_na_pagina_inicial() throws IOException {
        DriverNavegador.acessarSite("https://www.saucedemo.com/");
        DriverNavegador.printScreen("pagina inicial");
    }

    @Quando("informar os dados de login sem informar o usuario")
    public void informarOsDadosDeLoginSemInformarOUsuario() throws IOException {
        loginPage.setInpPassword(password);
        loginPage.clickBtnLogin();
    }

    @Entao("deve exibir mensagem de erro informando que o username e obrigatorio")
    public void deveExibirMensagemDeErroInformandoQueOUsernameEObrigatorio() throws IOException {
        Assert.assertEquals(erroUsername, loginPage.getErroUsername());
        DriverNavegador.printScreen("erro username");
    }

    @Quando("informar os dados de login sem informar a senha")
    public void informarOsDadosDeLoginSemInformarASenha() throws IOException {
        loginPage.clickSetInpUsername();
        loginPage.setInpUsername(username);
        loginPage.clickBtnLogin();
    }

    @Entao("deve exibir mensagem de erro informando que o password e obrigatorio")
    public void deveExibirMensagemDeErroInformandoQueOPasswordEObrigatorio() throws IOException {
        Assert.assertEquals(erroPassword, loginPage.getErroPassword());
        DriverNavegador.printScreen("erro password");
    }

    @Quando("informar os dados de login de um usuario bloqueado")
    public void informarOsDadosDeLoginDeUmUsuarioBloqueado() throws IOException {
        loginPage.clickSetInpUsername();
        loginPage.setInmpUsernameBlock(usernameBlock);
        loginPage.setInpPassword(password);
        loginPage.clickBtnLogin();
    }

    @Entao("deve exibir mensagem de erro informando que o usuario esta bloqueado")
    public void deveExibirMensagemDeErroInformandoQueOUsuarioEstaBloqueado() throws IOException {
        Assert.assertEquals(txtUsernameBlock, loginPage.getErroUserBlock());
        DriverNavegador.printScreen("erro login bloqueado");
    }

    @Quando("informar os dados de login")
    public void informarOsDadosDeLogin() throws IOException {
        loginPage.clickSetInpUsername();
        loginPage.setInpUsername(username);
        loginPage.setPasswordIncorreto(erroPassword);
        loginPage.clickBtnLogin();
    }

    @Entao("deve exibir mensagem de erro informando que o usuario e senha estão incorretos")
    public void deveExibirMensagemDeErroInformandoQueOUsuarioESenhaEstãoIncorretos() throws IOException {
        Assert.assertEquals(erroLogin, loginPage.getLoginIncorreto());
        DriverNavegador.printScreen("erro de login incorreto");
    }

    @Quando("informar login valido")
    public void informar_login_valido() throws IOException {
        loginPage.clickSetInpUsername();
        loginPage.setInpUsername(username);
        loginPage.setInpPassword(password);
        loginPage.clickBtnLogin();
    }

    @Entao("deve apresentar a tela inicial do sistema")
    public void deve_apresentar_a_tela_inicial_do_sistema() throws IOException {
        Assert.assertEquals(produtos, loginPage.getUsuarioLogado());
        DriverNavegador.printScreen("tela inicial do sistema");
    }

}
