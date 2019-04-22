package application.controller;

import application.service.CopiarArquivosService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class ArquivoController {

	private Stage dialogStage;
	
	@FXML
	private Button copiarbtn;

	@FXML
	private CheckBox git;

	@FXML
	private CheckBox java;

	@FXML
	private CheckBox ferramenta;




	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	CopiarArquivosService copiarArquivosService = new CopiarArquivosService();
	
	@FXML
	public void copiarArquivo() {
		copiarArquivosService.processar(git.isSelected(), java.isSelected() , ferramenta.isSelected());
	}
	

	

}
