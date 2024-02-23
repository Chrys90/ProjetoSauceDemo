package br.com.funcionalidades.compra;

import br.com.funcionalidades.driver.DriverNavegador;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdutosMaps {

    @FindBy(css = ".title")
    public WebElement txtProduto;

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    public WebElement btnComprarMochila;


    @FindBy(css = "#add-to-cart-sauce-labs-bike-light")
    public WebElement btnComprarLanternaBike;

    @FindBy(css = "#add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement btnComprarCamisaPreta;

    @FindBy(css = "#add-to-cart-sauce-labs-fleece-jacket")
    public WebElement btnComprarJaqueta;

    @FindBy(css = "#add-to-cart-sauce-labs-onesie")
    public WebElement btnComprarMacacaoInfantil;

    @FindBy(name = "add-to-cart-test.allthethings()-t-shirt-(red)")
    public WebElement btnComprarCamisaVermelha;


    public ProdutosMaps() {
        PageFactory.initElements(DriverNavegador.getDriver(), this);
    }
}
