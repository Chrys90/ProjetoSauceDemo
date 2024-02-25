package br.com.funcionalidades.login;

import br.com.funcionalidades.dados.MassaDados;
import br.com.funcionalidades.compra.ProdutosMaps;
import br.com.funcionalidades.driver.DriverNavegador;
import java.io.IOException;


public class LoginPage {

    ProdutosMaps produtosMaps;

    LoginMaps loginMaps;
    MassaDados massadados;

    public void clickBtnLogin() {
        loginMaps.btnLogin.click();
    }

    public void clickSetInpUsername() {
        loginMaps = new LoginMaps();
        loginMaps.inpUsername.click();
    }

    public void setInpUsername(String username) throws IOException {
        massadados = new MassaDados();
        username = MassaDados.getUsername();
        loginMaps.inpUsername.sendKeys(username);
    }

    public void setInpPassword(String password) throws IOException {
        password = MassaDados.getPassword();
        loginMaps.inpPassword.click();
        loginMaps.inpPassword.sendKeys(password);
    }

    public String getUsuarioLogado() {
        produtosMaps = new ProdutosMaps();
        DriverNavegador.visibilityOf(produtosMaps.txtProduto);
        return produtosMaps.txtProduto.getText();
    }

}
