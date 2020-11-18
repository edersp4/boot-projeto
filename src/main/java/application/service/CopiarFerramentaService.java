package application.service;

import application.Project;
import application.utils.AlertUtils;
import javafx.scene.control.Alert.AlertType;


public class CopiarFerramentaService {

    private GitService gitService;

    public CopiarFerramentaService() {
        this.gitService = new GitService();
    }


    public void clonarEFazerCheckout(boolean ehParaClonar) {

        for (Project projeto : SigletonProjetos.getProjetos()) {
                gitService.cloneRepo(
                        Configuracao.urlGit + projeto.getNome() + ".git",
                        Configuracao.caminhoLocal + "/" + projeto.getNome(), Configuracao.usuarioGit, Configuracao.senhaGit , projeto , ehParaClonar);


        }

        AlertUtils.criarAlerta(AlertType.INFORMATION, null , null, "Fim do processo");
    }


}
