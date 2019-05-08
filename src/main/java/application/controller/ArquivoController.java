package application.controller;

import application.service.CopiarFerramentaService;
import application.service.GitService;
import application.service.ProjetosService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class ArquivoController {


    CopiarFerramentaService copiarFerramentaService = new CopiarFerramentaService();
    private Stage dialogStage;
    @FXML
    private Button copiarbtn;
    @FXML
    private CheckBox sipdi;

    @FXML
    private CheckBox sigdf;

    @FXML
    private CheckBox sirff;

    @FXML
    private CheckBox java;
    @FXML
    private CheckBox ferramenta;
    @FXML
    private Button inicializar;

    private ProjetosService projetosService ;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    public void copiarFerramenta() {
        copiarFerramentaService.processar(java.isSelected(), ferramenta.isSelected());
    }


    private GitService gitService = new GitService();

    @FXML
    public void inicializar() {

        String property = System.getProperty("user.home");

        String usuario = System.getProperty("user.name");

       if(sipdi.isSelected()){
            projetosService = new ProjetosService("sipdi", usuario, "Caneta53");
            projetosService.gerarProjeto();
        }

        if(sigdf.isSelected()){
            projetosService = new ProjetosService("sigdf", usuario, "Caneta53");
            projetosService.gerarProjeto();
        }

        if(sirff.isSelected()){
            projetosService = new ProjetosService("sirff", usuario, "Caneta53");
            projetosService.gerarProjeto();
        }



    }

}
