package application.service;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class ProjetosService {
    public static final String PROJETO_PATH = "\\\\sp7266sr600\\PUBLICA\\CEDESSP334\\Boot\\";
    private final String nome;
    private final String usuario;
    private String password;
    private GitService gitService = new GitService();


    public ProjetosService(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.password = senha;
    }

    public void gerarProjeto() {
        File projetos = new File("C:" + File.separator + "projetos_aux" + File.separator + nome.toUpperCase());

        if (!projetos.exists()) {
            projetos.mkdirs();
        }

        try {
            FileUtils.copyDirectory(new File(PROJETO_PATH + File.separator + nome.toUpperCase()), projetos);
            gitService.cloneRepo("http://" + usuario + "@10.116.98.23/FINANCEIRO/" + nome + ".git", projetos.getPath() + File.separator + nome, usuario, password);
            gitService.cloneRepo("http://" + usuario + "@10.116.98.23/FINANCEIRO/" + nome + "-web.git", projetos.getPath() + File.separator + nome + "-web", usuario, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}