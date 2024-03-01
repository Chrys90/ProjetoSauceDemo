package br.com.funcionalidades.compra;

import br.com.funcionalidades.driver.DriverNavegador;
import br.com.funcionalidades.login.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;


public class CompraSteps {


    CompraPage compraPage = new CompraPage();
    String carrinhoDeCompras = "Your Cart";
    String checkout = "Checkout: Your Information";
    LoginPage loginPage;
    String produtos = "Products";
    String firstname;
    String lastname;
    String zipcode;
    String overview = "Checkout: Overview";
    String validarCompra = "Checkout: Complete!";



    @Dado("que esteja na pagina de produtos")
    public void que_esteja_na_pagina_de_produtos() throws IOException {
        loginPage = new LoginPage();
        Assert.assertEquals(produtos, loginPage.getUsuarioLogado());

    }

    @Quando("clicar em um produto")
    public void clicar_em_um_produto() throws IOException {
        compraPage.selecionarProduto();
    }

    @Entao("o produto deve ser incluido no carrinho de compras")
    public void o_produto_deve_ser_incluido_no_carrinho_de_compras() throws IOException {
        compraPage.carrinhoDeCompras();
        Assert.assertEquals(carrinhoDeCompras, compraPage.validarTelaCarrinhoDeCompras());
        DriverNavegador.printScreen("carrinho de compras");
    }

    @Dado("que esteja na tela do carrinho de compras")
    public void que_esteja_na_tela_do_carrinho_de_compras() {
        compraPage.carrinhoDeCompras();
        Assert.assertEquals(carrinhoDeCompras, compraPage.validarTelaCarrinhoDeCompras());
    }

    @Quando("clicar em checkout")
    public void clicar_em_checkout() {
        compraPage.clicarBtnCheckout();

    }

    @Entao("deve ser apresentado a tela para incluir informacoes do cliente")
    public void deve_ser_apresentado_a_tela_para_incluir_informacoes_do_cliente() throws IOException {
        compraPage.validarTelaCheckout();
        Assert.assertEquals(checkout, compraPage.validarTelaCheckout());
        DriverNavegador.printScreen("tela de informacoes do cliente");
    }

    @Dado("que esteja na tela de informacoes do cliente")
    public void que_esteja_na_tela_de_informacoes_do_cliente() {
        compraPage.validarTelaCheckout();
        Assert.assertEquals(checkout, compraPage.validarTelaCheckout());
    }

    @Quando("preencher as informacoes e clicar em Continue")
    public void preencher_as_informacoes_e_clicar_em_continue() throws IOException {
        compraPage.SetInpFirstName(firstname);
        compraPage.SetInpLastName(lastname);
        compraPage.SetInpZipCode(zipcode);
        compraPage.clicarBtnContiuar();
        DriverNavegador.printScreen("preenchimento dos dados do cliente");
    }

    @Entao("deve ser apresentado a tela de confirmacao do pedido")
    public void deve_ser_apresentado_a_tela_de_confirmacao_do_pedido() throws IOException {
        compraPage.validarTelaOverview();
        Assert.assertEquals(overview, compraPage.validarTelaOverview());
        DriverNavegador.printScreen("tela de confirmacao do pedido");
    }

    @Dado("que estja na tela de confirmacao do pedido")
    public void que_estja_na_tela_de_confirmacao_do_pedido() {
        compraPage.validarTelaOverview();
        Assert.assertEquals(overview, compraPage.validarTelaOverview());
    }

    @Quando("clicar em Finish")
    public void clicar_em_finish() {
        compraPage.clicarBtnFinish();
    }

    @Entao("deve ser apresentado a mensagem de confirmacao do pedido")
    public void deve_ser_apresentado_a_mensagem_de_confirmacao_do_pedido() throws IOException {
        compraPage.validarCompraConcluida();
        Assert.assertEquals(validarCompra, compraPage.validarCompraConcluida());
        DriverNavegador.printScreen("confirmacao do envio do pedido");
    }

}
