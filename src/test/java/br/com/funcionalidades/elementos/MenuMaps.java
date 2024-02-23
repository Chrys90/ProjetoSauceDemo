package br.com.funcionalidades.elementos;

import br.com.funcionalidades.driver.DriverNavegador;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuMaps {


    public MenuMaps() {
        PageFactory.initElements(DriverNavegador.getDriver(), this);
    }

    @FindBy(css = "#react-burger-menu-btn")
    public WebElement btnMenu;

    @FindBy(css = "#logout_sidebar_link")
    public WebElement btnLogout;


}
