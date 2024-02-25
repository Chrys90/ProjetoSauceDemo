package br.com.funcionalidades.compra;

import br.com.funcionalidades.dados.MassaDados;
import br.com.funcionalidades.driver.DriverNavegador;

import java.io.IOException;

public class CompraPage {

    CompraMaps compraMaps = new CompraMaps();
    ProdutosMaps produtosMaps;
    MassaDados massaDados;


    public void selecionarProduto(){
        produtosMaps = new ProdutosMaps();
        DriverNavegador.visibilityOf(produtosMaps.txtProduto);
        produtosMaps.btnComprarMochila.click();
        produtosMaps.btnComprarLanternaBike.click();
        produtosMaps.btnComprarCamisaPreta.click();
        produtosMaps.btnComprarJaqueta.click();
        produtosMaps.btnComprarMacacaoInfantil.click();
        produtosMaps.btnComprarCamisaVermelha.click();
    }

    public void carrinhoDeCompras() {
        compraMaps.btnCarrinhoDeCompras.click();
        try { Thread.sleep (600); } catch (InterruptedException falha) {}
    }

    public String validarTelaCarrinhoDeCompras()  {
        DriverNavegador.visibilityOf(compraMaps.txtTituloCarrinhoDeCompras);
        return compraMaps.txtTituloCarrinhoDeCompras.getText();

    }

    public void clicarBtnCheckout(){
        compraMaps.btnCheckout.click();
    }

    public String validarTelaCheckout(){
        DriverNavegador.visibilityOf(compraMaps.txtCheckout);
        return compraMaps.txtCheckout.getText();
    }

    public void SetInpFirstName(String firstName) throws IOException {
        massaDados = new MassaDados();
        firstName = MassaDados.getFirstName();
        compraMaps.inpFirstName.sendKeys(firstName);

    }

    public void SetInpLastName(String lastname) throws IOException {
        massaDados = new MassaDados();
        lastname = MassaDados.getLastName();
        compraMaps.inpLastName.sendKeys(lastname);

    }

    public void SetInpZipCode(String zipcode) throws IOException {
        massaDados = new MassaDados();
        zipcode = MassaDados.getZipCode();
        compraMaps.inpCodigoPostal.sendKeys(zipcode);

    }

    public void clicarBtnContiuar(){
        compraMaps.btnContinuar.click();
    }

    public String validarTelaOverview(){
        DriverNavegador.visibilityOf(compraMaps.txtOverview);
        return compraMaps.txtOverview.getText();
    }

    public void clicarBtnFinish(){
        compraMaps.btnFinalizarCompra.click();
    }

    public String validarCompraConcluida(){
        DriverNavegador.visibilityOf(compraMaps.txtCompraConcluida);
        return compraMaps.txtCompraConcluida.getText();
    }

}


