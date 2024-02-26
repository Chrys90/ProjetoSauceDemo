package br.com.funcionalidades.dados;

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
        String username; //Variavel que guardara o login do servidor.
        String password; //Variavel que guardara o host do servidor.
        String firstName; // Variavel que guardara o primeiro nome do cliente no checkout
        String lastName; // Variavel que guardara o ultimo nome do cliente no checkout
        String zipCode; // Variavel que guardara o codigo postal do cliente no checkout
        String usernameBlock; // Variavel que guardara o usuario bloqueado
        String passwordErro; // Variavel que guardara a senha incorreta

        Properties prop = getProp();

        username = prop.getProperty("username.standard");
        password = prop.getProperty("password.standard");
        firstName = prop.getProperty("first.name");
        lastName = prop.getProperty("last.name");
        zipCode =  prop.getProperty("zip.code");
        usernameBlock = prop.getProperty("username.locked");
        passwordErro = prop.getProperty("password.test");
    }
    public static String getUsername() throws IOException {
        return getProp().getProperty("username.standard");
    }

    public static String getPasswordIncorreto() throws IOException {
        return getProp().getProperty("password.test");
    }

    public static String getUsernameBlock() throws IOException {
        return  getProp().getProperty("username.locked");
    }

    public static String getPassword() throws IOException {
        return getProp().getProperty("password.standard");
    }

    public static String getFirstName () throws IOException {
        return getProp().getProperty("first.name");
    }

    public static String getLastName () throws IOException {
        return getProp().getProperty("last.name");
    }

    public static String getZipCode () throws IOException {
        return getProp().getProperty("zip.code");
    }

}
