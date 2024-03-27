package br.com.funcionalidades.login;

import br.com.funcionalidades.compra.ProdutosMaps;
import br.com.funcionalidades.dados.MassaDados;
import br.com.funcionalidades.utils.Commands;

import java.io.IOException;


public class LoginPage {

    ProdutosMaps produtosMaps;

    LoginMaps loginMaps = new LoginMaps();

    public void clickBtnLogin() {
        loginMaps.btnLogin.click();
    }

    public void clickSetInpUsername() {
        loginMaps.inpUsername.click();
    }

    public void setInpUsername() throws IOException {
        String username = MassaDados.getUsername();
        Commands.preencherCampo(loginMaps.inpUsername, username);
    }

    public void setInmpUsernameBlock() throws IOException {
        String usernameBlock = MassaDados.getUsernameBlock();
        Commands.preencherCampo(loginMaps.inpUsername, usernameBlock);
    }

    public void setInpPassword() throws IOException {
        String password = MassaDados.getPassword();
        Commands.clique(loginMaps.inpPassword);
        Commands.preencherCampo(loginMaps.inpPassword, password);
    }

    public void setPasswordIncorreto() throws IOException {
        String passwordIncorreto = MassaDados.getPasswordIncorreto();
        Commands.clique(loginMaps.inpPassword);
        Commands.preencherCampo(loginMaps.inpPassword, passwordIncorreto);
    }

    public void validarLoginSucesso() {
        produtosMaps = new ProdutosMaps();
        Commands.validarMensagem(produtosMaps.txtProduto,"Products" );
    }

    public void validarErroUsername() {
        Commands.validarMensagem(loginMaps.txtErroUsername, "Epic sadface: Username is required");
    }

    public void validarErroPassword() {
        Commands.validarMensagem(loginMaps.txtErroPassword, "Epic sadface: Password is required");
    }

    public void validarErroUsuarioBlock() {
        Commands.validarMensagem(loginMaps.txtUserBlock, "Epic sadface: Sorry, this user has been locked out.");
    }

    public void validarLoginIncorreto() {
        Commands.validarMensagem(loginMaps.txtErroLogin,"Epic sadface: Username and password do not match any user in this service");
    }
}
