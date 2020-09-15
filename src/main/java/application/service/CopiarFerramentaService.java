package application.service;

import org.eclipse.jgit.api.errors.GitAPIException;

import javax.swing.*;
import java.io.File;

public class CopiarFerramentaService {

    //https://gitlab-prd1.accesstage.com.br/veragi/frontend-veragi.git

    private GitService gitService;

    public CopiarFerramentaService() {
        this.gitService = new GitService();
    }

    public void processar(boolean java, boolean ferramenta) {

        Runnable iniciar = () -> {

            File tools = new File(Configuracao.caminhoLocal);

            try {
                criarDiretorioCasoNaoExitir(tools);

                if (ferramenta)
                    new Ferramenta().executar();

                if (java) {
                    new JavaService().executar();
                }
                JOptionPane.showMessageDialog(null, "Foi copiado com sucesso!");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
                e1.printStackTrace();
            }
        };

        Thread thread = new Thread(iniciar);

        thread.start();

    }

    private void criarDiretorioCasoNaoExitir(File tools) {
        if (!tools.exists()) {
            tools.mkdirs();
        }
    }


    public void baixarTodosOsProjetosPeloGit() {
        for (String projeto : Configuracao.projetos) {
                gitService.cloneRepo(
                        Configuracao.urlGit + projeto + ".git",
                        Configuracao.caminhoLocal + "/" + projeto, "ede.silva", "12345678");


        }
    }


}
