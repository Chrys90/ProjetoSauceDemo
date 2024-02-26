package br.com.funcionalidades.login;

import br.com.funcionalidades.driver.DriverNavegador;
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


    @Dado("que esteja na pagina inicial")
    public void que_esteja_na_pagina_inicial() {
        DriverNavegador.getDriver();
        DriverNavegador.acessarSite("https://www.saucedemo.com/");

    }

    @Quando("informar os dados de login sem informar o usuario")
    public void informarOsDadosDeLoginSemInformarOUsuario() throws IOException {
        loginPage.setInpPassword(password);
        loginPage.clickBtnLogin();

    }

    @Entao("deve exibir mensagem de erro informando que o username e obrigatorio")
    public void deveExibirMensagemDeErroInformandoQueOUsernameEObrigatorio() {
        Assert.assertEquals(erroUsername, loginPage.getErroUsername());
    }

    @Quando("informar os dados de login sem informar a senha")
    public void informarOsDadosDeLoginSemInformarASenha() throws IOException {
        loginPage.clickSetInpUsername();
        loginPage.setInpUsername(username);
        loginPage.clickBtnLogin();
    }

    @Entao("deve exibir mensagem de erro informando que o password e obrigatorio")
    public void deveExibirMensagemDeErroInformandoQueOPasswordEObrigatorio() {
        Assert.assertEquals(erroPassword, loginPage.getErroPassword());
    }

    @Quando("informar os dados de login de um usuario bloqueado")
    public void informarOsDadosDeLoginDeUmUsuarioBloqueado() throws IOException {
        loginPage.clickSetInpUsername();
        loginPage.setInmpUsernameBlock(usernameBlock);
        loginPage.setInpPassword(password);
        loginPage.clickBtnLogin();
    }

    @Entao("deve exibir mensagem de erro informando que o usuario esta bloqueado")
    public void deveExibirMensagemDeErroInformandoQueOUsuarioEstaBloqueado() {
        Assert.assertEquals(txtUsernameBlock, loginPage.getErroUserBlock());
    }

    @Quando("informar os dados de login")
    public void informarOsDadosDeLogin() throws IOException {
        loginPage.clickSetInpUsername();
        loginPage.setInpUsername(username);
        loginPage.setPasswordIncorreto(erroPassword);
        loginPage.clickBtnLogin();
    }

    @Entao("deve exibir mensagem de erro informando que o usuario e senha estão incorretos")
    public void deveExibirMensagemDeErroInformandoQueOUsuarioESenhaEstãoIncorretos() {
        Assert.assertEquals(erroLogin, loginPage.getLoginIncorreto());
    }


    @Quando("informar login valido")
    public void informar_login_valido() throws IOException {
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
