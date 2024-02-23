package br.com.funcionalidades.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverNavegador {

    private static WebDriverWait wait;

    static WebDriver driver;

    public DriverNavegador() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void visibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebDriver getDriver() {

        return driver;
    }

    public void acessarSite(String site) {
        driver.get(site);
    }

    public static void fecharNavegador() {
        driver.quit();
    }


}