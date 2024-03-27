package br.com.funcionalidades.driver;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DriverNavegador {

    private static WebDriverWait wait;

    private static WebDriver driver;
    private static File diretorio;
    private static int numPrint;
    private static String nomeCenario;


    public static void setNomeCenario(String nomeCenario) {
        DriverNavegador.nomeCenario = nomeCenario;
    }

    private static void startChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
    }

    private static void startFirefox(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        driver =  new FirefoxDriver(firefoxOptions);
    }

    private static void startEdge(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless");
        driver =  new EdgeDriver(edgeOptions);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser");
            driver = createDriver(browser);
        }
        return driver;
    }

    public static void acessarAplicao(String site) {
        getDriver().get(site);
    }

    private static WebDriver createDriver(String browser) {

        switch (browser) {
            case "chrome":
                startChrome();
                break;

            case "firefox":
                startFirefox();
                break;

            case "edge":
                startEdge();
                break;
            default:
                throw new IllegalArgumentException("Navegador não encontrado! Passe um navegador existente: chrome, firefox ou edge.");
        }

        if(driver != null){
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return driver;
    }

    public static void fecharNavegador() {
        getDriver().quit();
    }


    public static void criaDiretorio() {
        String caminho = "src/test/resources/evidencias";
        diretorio = new File(caminho + "/" + nomeCenario);
        diretorio.mkdir();
        numPrint = 0;
    }

    public static void printScreen(String passo) throws IOException {
        numPrint++;
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String caminho = diretorio.getPath() + "/" + numPrint + " - " + passo + ".png";
        FileUtils.copyFile(file, new File(caminho));

    }

    public static void cenarioErroScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            // Captura o screenshot como um array de bytes
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            // Anexa o screenshot ao relatório
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

}

