package br.com.funcionalidades.driver;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DriverNavegador {

    private static WebDriverWait wait;

    static WebDriver driver;
    private static File diretorio;
    private static int numPrint;
    private static String nomeCenario;


    public static String getNomeCenario() {
        return nomeCenario;
    }

    public static void setNomeCenario(String nomeCenario) {
        DriverNavegador.nomeCenario = nomeCenario;
    }

    private static void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public static void visibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            startChrome();
        }
        return driver;
    }

    public static void acessarSite(String site) {
        driver.get(site);
    }

    public static void fecharNavegador() {
        driver.quit();
    }


    public static void criaDiretorio() {
        String caminho = "src/test/resources/evidencias";
        diretorio = new File(caminho + "/" + nomeCenario);
        diretorio.mkdir();
        numPrint = 0;
    }

    public static void printScreen(String passo) throws IOException {
        numPrint++;
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String caminho = diretorio.getPath() + "/" + numPrint + " - " + passo + ".png";
        FileUtils.copyFile(file, new File(caminho));

    }

    public static void cenarioErroScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            // Captura o screenshot como um array de bytes
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // Anexa o screenshot ao relatório
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

}

