package br.com.funcionalidades.login;

import br.com.funcionalidades.driver.DriverNavegador;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginMaps {

    public LoginMaps() {
        PageFactory.initElements(DriverNavegador.getDriver(), this);
    }


    @FindBy(css = "#user-name")
    WebElement inpUsername;

    @FindBy(css = "#password")
    WebElement inpPassword;

    @FindBy(css = "#login-button")
    WebElement btnLogin;


}
