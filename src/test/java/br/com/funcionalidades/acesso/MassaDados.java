package br.com.funcionalidades.acesso;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MassaDados {


    private static Properties getProp() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("src/test/resources/dados/dados.properties");
        prop.load(file);
        return prop;

    }

    private static void dadosAcesso() throws IOException {
        String username; //Variavel que guardará o login do servidor.
        String password; //Variavel que guardará o host do servidor.

        Properties prop = getProp();

        username = prop.getProperty("username.standard");
        password = prop.getProperty("password.standard");

    }
    public static String getUsername() throws IOException {
        return getProp().getProperty("username.standard");
    }

    public static String getPassword() throws IOException {
        return getProp().getProperty("password.standard");
    }



}
