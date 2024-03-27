package br.com.funcionalidades.compra;

import br.com.funcionalidades.dados.MassaDados;
import br.com.funcionalidades.utils.Commands;

import java.io.IOException;

public class CompraPage {

    CompraMaps compraMaps = new CompraMaps();
    ProdutosMaps produtosMaps;
    MassaDados massaDados;


    public void selecionarProduto(){
        produtosMaps = new ProdutosMaps();
        Commands.waitElementBeVisible(produtosMaps.txtProduto, 10000);
        Commands.clique(produtosMaps.btnComprarMochila);
        Commands.clique(produtosMaps.btnComprarLanternaBike);
        Commands.clique(produtosMaps.btnComprarCamisaPreta);
        Commands.clique(produtosMaps.btnComprarJaqueta);
        Commands.clique(produtosMaps.btnComprarMacacaoInfantil);
        Commands.clique(produtosMaps.btnComprarCamisaVermelha);
    }

    public void carrinhoDeCompras() {
        Commands.clique(compraMaps.btnCarrinhoDeCompras);
    }

    public void validarTelaCarrinhoDeCompras()  {
        Commands.validarMensagem(compraMaps.txtTituloCarrinhoDeCompras,"Your Cart");
    }

    public void clicarBtnCheckout(){
        Commands.clique(compraMaps.btnCheckout);
    }

    public void validarTelaCheckout(){
        Commands.validarMensagem(compraMaps.txtCheckout,"Checkout: Your Information");
    }

    public void preencherFirstName() throws IOException {
        massaDados = new MassaDados();
        String firstName = MassaDados.getFirstName();
        Commands.preencherCampo(compraMaps.inpFirstName, firstName);
    }

    public void preencherLastName() throws IOException {
        massaDados = new MassaDados();
        String lastname = MassaDados.getLastName();
        Commands.preencherCampo(compraMaps.inpLastName, lastname);

    }

    public void preencherZipCode() throws IOException {
        massaDados = new MassaDados();
        String zipcode = MassaDados.getZipCode();
        Commands.preencherCampo(compraMaps.inpCodigoPostal, zipcode);
    }

    public void clicarBtnContiuar(){
        Commands.clique(compraMaps.btnContinuar);
    }

    public void validarTelaOverview(){
        Commands.validarMensagem(compraMaps.txtOverview, "Checkout: Overview");
    }

    public void clicarBtnFinish(){
        Commands.clique(compraMaps.btnFinalizarCompra);
    }

    public void validarCompraConcluida(){
        Commands.validarMensagem(compraMaps.txtCompraConcluida, "Checkout: Complete!");
    }

}


