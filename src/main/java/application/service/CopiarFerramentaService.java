package application.service;

import org.eclipse.jgit.api.errors.GitAPIException;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class CopiarFerramentaService {
    //https://gitlab-prd1.accesstage.com.br/veragi/frontend-veragi.git
    public static final String DIRETORIO_ROOT = "/Users/ederson/desenvolvimento";
    GitService gitService = new GitService();
    private static String URL_PARA_CLONE = "https://gitlab-prd1.accesstage.com.br/veragi/";
    private static List<String> projetos = List.of(
            "mer",
            "integration-kobold-feign",
            "integration-kobold",
            "edi",
            "edi-feign",
            "veragi-public",
            "identity-access-feign",
            "identity-access",
            "business-utils",
            "register-base-feign",
            "register-base",
            "oauth-feign",
            "oauth",
            "prepayment-feign",
            "prepayment",
            "invoice-draft-feign",
            "invoice-draft",
            "storage-file-feign",
            "storage-file",
            "profile-feign",
            "profile",
            "global-parameter-feign",
            "global-parameter",
            "rw-files",
            "library-utils",
            "veragi-gateway",
            "small-batches",
            "edi-prepayment",
            "frontend-veragi"

    );


    public void processar(boolean java, boolean ferramenta) {

        Runnable iniciar = () -> {

            File tools = new File(DIRETORIO_ROOT);

            try {
                if (!tools.exists()) {
                    tools.mkdirs();
                }

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


    public void baixarTodosOsProjetosPeloGit() {
        projetos.forEach(projeto -> {
            try {
                gitService.cloneRepo(URL_PARA_CLONE + projeto + ".git", DIRETORIO_ROOT + "/" + projeto, "ede.silva",
                        "12345678");
            } catch (GitAPIException e) {
                e.printStackTrace();
            }

        });
    }
}
