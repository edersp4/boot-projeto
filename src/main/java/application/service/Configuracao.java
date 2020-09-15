package application.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracao {
    public static String usuarioGit;
    public static String senhaGit;
    public static String caminhoLocal;
    public static String urlGit;
    public static String[] projetos;


    static {
        carregarConfiguracao();
    }

    public Configuracao() {
        carregarConfiguracao();
    }

    private static void carregarConfiguracao() {
        try {
            InputStream resource = Configuracao.class.getClassLoader()
                    .getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(resource);
            caminhoLocal = properties.getProperty("caminho-local");
            usuarioGit = properties.getProperty("usuario-git");
            senhaGit = properties.getProperty("senha-git");
            urlGit = properties.getProperty("url-git");
            projetos = properties.getProperty("projetos")
                    .split(",");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
