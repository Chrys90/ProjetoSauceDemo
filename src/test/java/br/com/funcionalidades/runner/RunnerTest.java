package br.com.funcionalidades.runner;

import br.com.funcionalidades.driver.DriverNavegador;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        tags = "",
        glue = "br.com.funcionalidades",
        plugin = {"json:target/reports/CucumberReports.json", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {

    @AfterClass
    public static void fechaNavegador() {
        System.out.println("Fechando navegador...");
        DriverNavegador.fecharNavegador();
    }


}
