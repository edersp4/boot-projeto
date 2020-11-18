package application;

import application.service.CopiarFerramentaService;
import application.service.SigletonProjetos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ArquivoController implements Initializable {


    CopiarFerramentaService copiarFerramentaService = new CopiarFerramentaService();
    private Stage dialogStage;
    @FXML
    private Button copiarbtn;
    @FXML
    private CheckBox apenasCheckout;
    @FXML
    private Button inicializar;
    @FXML
    private TableView tableProjects;
    private Task<Void> task;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    public void copiarFerramenta() {

        if (task == null) {
            System.out.println("Teste já está rodando");
        }

        task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                copiarFerramentaService.clonarEFazerCheckout(apenasCheckout.isSelected());
                return null;
            }
        };

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn nome = new TableColumn("Nome");
        TableColumn baixado = new TableColumn("Baixado");
        TableColumn tagOuBranch = new TableColumn("Tag ou Branch");
        tableProjects.getColumns().addAll(nome  , tagOuBranch , baixado);


        ObservableList<Project> data = FXCollections.observableArrayList(SigletonProjetos.getProjetos());

        nome.setCellValueFactory(new PropertyValueFactory<Project, String>("nome"));
        baixado.setCellValueFactory(new PropertyValueFactory<Project, String>("baixado"));
        tagOuBranch.setCellValueFactory(new PropertyValueFactory<Project , String>("tag"));


        tableProjects.setItems(data);

    }



}
