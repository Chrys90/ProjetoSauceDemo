package br.com.funcionalidades.compra;

import br.com.funcionalidades.driver.DriverNavegador;

public class CompraPage {

    CompraMaps compraMaps;
    ProdutosMaps produtosMaps;


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
        compraMaps = new CompraMaps();
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
        return compraMaps.btnCheckout.getText();
    }

}


