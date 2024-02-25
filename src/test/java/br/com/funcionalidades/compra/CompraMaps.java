package br.com.funcionalidades.compra;

import br.com.funcionalidades.driver.DriverNavegador;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraMaps {


    @FindBy(css = ".shopping_cart_link")
    public WebElement btnCarrinhoDeCompras;

    @FindBy(css = "#checkout")
    public WebElement btnCheckout;

    @FindBy(css = "#continue-shopping")
    public WebElement btnContinuarCompra;

    @FindBy(css = "#cancel")
    public WebElement btnCancelarCompra;

    @FindBy(css = "#continue")
    public WebElement btnContinuar;

    @FindBy(css = "#first-name")
    public WebElement inpFirstName;

    @FindBy(css = "#last-name")
    public WebElement inpLastName;

    @FindBy(css = "#postal-code")
    public WebElement inpCodigoPostal;

    @FindBy(css = "#finish")
    public WebElement btnFinalizarCompra;

    @FindBy(css = "#back-to-products")
    public WebElement btnVoltarAosProdutos;

    @FindBy(xpath = "//span [text()='Your Cart']")
    public WebElement txtTituloCarrinhoDeCompras;

    @FindBy(css = ".title")
    public WebElement txtCheckout;

    @FindBy(css = ".title")
    public WebElement txtOverview;

    @FindBy(css = ".title")
    public WebElement txtCompraConcluida;
    public CompraMaps() {
        PageFactory.initElements(DriverNavegador.getDriver(), this);
    }
}
