package br.com.funcionalidades.login;

import br.com.funcionalidades.dados.MassaDados;
import br.com.funcionalidades.compra.ProdutosMaps;
import br.com.funcionalidades.driver.DriverNavegador;
import java.io.IOException;


public class LoginPage {

    ProdutosMaps produtosMaps;

    LoginMaps loginMaps = new LoginMaps();
    MassaDados massadados = new MassaDados();

    public void clickBtnLogin() {
        loginMaps.btnLogin.click();
    }

    public void clickSetInpUsername() {
        loginMaps.inpUsername.click();
    }

    public void setInpUsername(String username) throws IOException {
        username = MassaDados.getUsername();
        loginMaps.inpUsername.sendKeys(username);
    }

    public void setInmpUsernameBlock(String usernameBlock) throws IOException {
        usernameBlock = MassaDados.getUsernameBlock();
        loginMaps.inpUsername.sendKeys(usernameBlock);
    }

    public void setInpPassword(String password) throws IOException {
        password = MassaDados.getPassword();
        loginMaps.inpPassword.click();
        loginMaps.inpPassword.sendKeys(password);
    }

    public void setPasswordIncorreto(String passwordIncorreto) throws IOException {
        passwordIncorreto = MassaDados.getPasswordIncorreto();
        loginMaps.inpPassword.click();
        loginMaps.inpPassword.sendKeys(passwordIncorreto);
    }

    public String getUsuarioLogado() {
        produtosMaps = new ProdutosMaps();
        DriverNavegador.visibilityOf(produtosMaps.txtProduto);
        return produtosMaps.txtProduto.getText();
    }

    public String getErroUsername(){
       DriverNavegador.visibilityOf(loginMaps.txtErroUsername);
       return loginMaps.txtErroUsername.getText();
    }

    public String getErroPassword(){
        DriverNavegador.visibilityOf(loginMaps.txtErroPassword);
        return loginMaps.txtErroPassword.getText();
    }

    public String getErroUserBlock(){
        DriverNavegador.visibilityOf(loginMaps.txtUserBlock);
        return loginMaps.txtUserBlock.getText();
    }

    public String getLoginIncorreto(){
        DriverNavegador.visibilityOf(loginMaps.txtErroLogin);
        return  loginMaps.txtErroLogin.getText();
    }
}
